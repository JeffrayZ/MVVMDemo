package com.example.mvvmdemo1.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 14:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 14:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity<VM : BaseViewModel, VDB : ViewDataBinding> :
    AppCompatActivity() {
    /**获取当前activity布局文件,并初始化我们的binding*/
    protected abstract fun getContentViewId(): Int
    //处理逻辑业务
    protected abstract fun processLogic()

    protected var mViewModel: VM? = null
    protected lateinit var binding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getContentViewId())
        // 实现双向绑定，必须写这个
        binding.lifecycleOwner = this

        //创建我们的ViewModel
        createViewModel()
        processLogic()
    }

    @Suppress("UNCHECKED_CAST")
    public fun createViewModel(){
        if(mViewModel == null){
            val modelClass:Class<VM>
            val type = javaClass.genericSuperclass
            modelClass = if(type is ParameterizedType){
                // 获取第一个参数，强转成 Class<VM>
                type.actualTypeArguments[0] as Class<VM>
            } else {
                // 如果没有指定泛型参数，则默认使用BaseViewModel
                BaseViewModel::class.java as Class<VM>
            }
            mViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(modelClass) as VM
        }
    }
}
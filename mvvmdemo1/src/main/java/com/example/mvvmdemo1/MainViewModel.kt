package com.example.mvvmdemo1

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo1.base.BaseViewModel
import com.example.mvvmdemo1.base.ResponseResult
import com.example.mvvmdemo1.bean.BannerBean
import com.example.mvvmdemo1.manager.RetrofitManager
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1
 * @ClassName: MainViewModel
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 15:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 15:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MainViewModel(application: Application) :
    BaseViewModel(application) {

    fun getBanner(): MutableLiveData<ResponseResult<MutableList<BannerBean?>?>?>? {
        val liveData = MutableLiveData<ResponseResult<MutableList<BannerBean?>?>?>()
        RetrofitManager.apiService?.getBanner()?.subscribeOn(Schedulers.io())?.doOnSubscribe {
            liveData.postValue(ResponseResult.loading("正在加载"))
        }?.subscribe(Consumer {
            liveData.postValue(ResponseResult.success(it?.data));
        }, Consumer {
            liveData.postValue(ResponseResult.error(it))
        })
        return liveData
    }
}
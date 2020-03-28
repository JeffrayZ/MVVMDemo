package com.example.mvvmdemo1.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.base
 * @ClassName: BaseViewModel
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 14:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 14:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
open class BaseViewModel(application: Application): AndroidViewModel(application) {
    override fun onCleared() {
        super.onCleared()
    }
}
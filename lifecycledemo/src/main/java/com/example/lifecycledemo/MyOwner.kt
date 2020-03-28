package com.example.lifecycledemo

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.lifecycledemo
 * @ClassName: MyOwner
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 14:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 14:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MyOwner : LifecycleOwner {

    constructor() {
        mLifecycleRegistry.addObserver(MyObserver())
    }

    private val mLifecycleRegistry =
        LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

    fun onCreat() {
        LogUtils.i("MyOwner >>> onCreat")
        mLifecycleRegistry.currentState = Lifecycle.State.CREATED;
    }
}
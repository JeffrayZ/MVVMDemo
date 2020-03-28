package com.example.lifecycledemo

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecycledemo.LogUtils.i

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.lifecycledemo
 * @ClassName: MyObserver
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 14:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 14:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MyObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        i("MyObserver  onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        i("MyObserver  onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        i("MyObserver  onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        i("MyObserver  onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        i("MyObserver  onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        i("MyObserver  onDestory")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        i("MyObserver  onAny")
    }
}
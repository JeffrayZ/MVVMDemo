package com.example.mvvmdemo1.base

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.base
 * @ClassName: OnHandleCallback
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 18:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 18:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class OnHandleCallback<T> {
    open fun onLoading(showMessage: String?) {

    }

    open fun onSuccess(data: T?) {

    }

    open fun onFailure(msg: String?) {

    }

    open fun onError(error: Throwable?) {

    }

    open fun onCompleted() {

    }

    open fun onProgress(precent: Int, total: Long) {

    }
}
package com.example.mvvmdemo1

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 18:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 18:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class Test {
    private fun setCallback() {
        val testCall = TestCall<String>()
        testCall.call(object : TestCallback<String>() {

        })
    }

    abstract class TestCallback<T> {
        open fun onLoading(){}
        open fun onSuccess() {}
        open fun onFailure() {}
        open fun onError() {}
        open fun onCompleted() {}
        open fun onProgress() {}
    }

    class TestCall<T> {
        var i = 1
        public fun call(callback: TestCallback<T>) {
            if (i == 1) {
                callback.onCompleted()
            } else {
                callback.onError()
            }
        }
    }
}
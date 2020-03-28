package com.example.liviedatademo

import android.util.Log

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.viewmodeldemo
 * @ClassName: LogUtils
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/23 14:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 14:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
object LogUtils {
    private const val TAG: String = "LivewDataDemo"
    fun i(msg: String) {
        Log.e(TAG, msg)
    }
}
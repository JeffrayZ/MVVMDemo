package com.example.mvvmdemo1.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.base
 * @ClassName: ResponModel
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 15:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 15:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
data class ResponModel<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String?
) : Serializable {
    val isSuccess: Boolean
        get() = RESULT_SUCCESS == errorCode

    companion object {
        const val RESULT_SUCCESS = 0
    }
}
package com.example.mvvmdemo1.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.bean
 * @ClassName: BannerBean
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 15:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 15:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Parcelize
data class BannerBean(
    /**
     * desc : Android高级进阶直播课免费学习
     * id : 23
     * imagePath : https://wanandroid.com/blogimgs/67c28e8c-2716-4b78-95d3-22cbde65d924.jpeg
     * isVisible : 1
     * order : 0
     * title : Android高级进阶直播课免费学习
     * type : 0
     * url : https://url.163.com/4bj
     */
    var desc: String? = null,
    var id: Int = 0,
    var imagePath: String? = null,
    var isVisible: Int = 0,
    var order: Int = 0,
    var title: String? = null,
    var type: Int = 0,
    var url: String? = null
) : Parcelable
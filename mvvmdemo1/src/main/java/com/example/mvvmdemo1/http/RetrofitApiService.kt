package com.example.mvvmdemo1.http

import com.example.mvvmdemo1.base.ResponModel
import com.example.mvvmdemo1.bean.BannerBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.http
 * @ClassName: RetrofitApiService
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 15:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 15:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface RetrofitApiService {
    @GET("banner/json")
    open fun getBanner(): Observable<ResponModel<MutableList<BannerBean?>?>?>?
}
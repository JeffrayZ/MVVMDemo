package com.example.mvvmdemo1.manager

import com.example.mvvmdemo1.http.RetrofitApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.manager
 * @ClassName: RetrofitManager
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 15:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 15:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class RetrofitManager private constructor() {
    private var retrofit: Retrofit? = null
    private var retrofitApiService: RetrofitApiService? = null
    private fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofitApiService = retrofit?.create(RetrofitApiService::class.java)
    }

    companion object {
        private val retrofitManager by lazy{
            RetrofitManager()
        }
        val apiService: RetrofitApiService?
            get() = retrofitManager.retrofitApiService
    }

    init {
        initRetrofit()
    }
}
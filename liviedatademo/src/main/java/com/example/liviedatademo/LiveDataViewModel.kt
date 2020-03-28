package com.example.liviedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.liviedatademo
 * @ClassName: LiveDataViewModel
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/23 15:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LiveDataViewModel() : ViewModel() {
    private val nameLiveData: MutableLiveData<String> = MutableLiveData()
    fun getData(): MutableLiveData<String> {
        return nameLiveData
    }
}
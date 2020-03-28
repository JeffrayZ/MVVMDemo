package com.example.liviedatademo

import androidx.databinding.ObservableField

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.liviedatademo
 * @ClassName: TestBean
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 10:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 10:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class TestBean {
    val nameObservable: ObservableField<String> = ObservableField();

    fun setName(name: String) {
        this.nameObservable.set(name);
    }
}
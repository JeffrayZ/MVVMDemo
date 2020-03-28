package com.example.viewmodeldemo

import androidx.lifecycle.ViewModel

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.viewmodeldemo
 * @ClassName: MyViewModel
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/23 14:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 14:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MyViewModel():ViewModel() {
    override fun onCleared() {
        super.onCleared()
        LogUtils.i("Activity被杀死后也会被销毁！")
    }
}
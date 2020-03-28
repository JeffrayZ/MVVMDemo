package com.example.viewmodeldemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myViewModel: MyViewModel =
            ViewModelProvider(this).get(
                MyViewModel::class.java
            )
        LogUtils.i("onCreate ${myViewModel.hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        LogUtils.i("onStart ${myViewModel.hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        LogUtils.i("onResume ${myViewModel.hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        LogUtils.i("onPause ${myViewModel.hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        LogUtils.i("onStop ${myViewModel.hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        LogUtils.i("onRestart ${myViewModel.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        val myViewModel: MyViewModel = ViewModelProvider(this).get(
            MyViewModel::class.java
        )
        // 这里的hashCode会变
        LogUtils.i("onDestroy ${myViewModel.hashCode()}")
    }
}

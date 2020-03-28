package com.example.liviedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.liviedatademo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val liveData = MutableLiveData<String>()
    lateinit var liveDataViewModel: LiveDataViewModel
    private lateinit var binding:ActivityMainBinding
    private lateinit var testBean: TestBean


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        liveDataViewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                LiveDataViewModel::class.java
            )

        // 点击按钮改变
        changeData.setOnClickListener {
            liveData.postValue("改变数据:::${(Math.random() * 1000).toInt()}")
        }

        // onStop 里面改变
        liveData.observe(this, Observer {
            tvResult.text = it
        })

        testBean = TestBean()
        binding.tb = testBean


        binding.lifecycleOwner = this
        binding.ldvm = liveDataViewModel
    }

    override fun onStop() {
        super.onStop()
        liveData.postValue("单独LiveData使用");
        testBean.nameObservable.set("我是DataBinding双向绑定")
        liveDataViewModel.getData().postValue("livedata双向绑定")
    }
}

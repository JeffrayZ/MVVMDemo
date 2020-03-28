package com.example.mvvmdemo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.mvvmdemo1.banner.GlideImageLoader
import com.example.mvvmdemo1.base.BaseActivity
import com.example.mvvmdemo1.base.OnHandleCallback
import com.example.mvvmdemo1.base.ResponseResult
import com.example.mvvmdemo1.bean.BannerBean
import com.example.mvvmdemo1.databinding.ActivityMainBinding
import com.youth.banner.BannerConfig

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main;
    }

    override fun processLogic() {
        initBanner();
        binding.btn.setOnClickListener {
            getBanner();
        }
    }

    private lateinit var alertDialog:AlertDialog

    private fun getBanner() {
        mViewModel?.getBanner()?.observe(this, Observer {
            it?.handler(object : OnHandleCallback<MutableList<BannerBean?>?>() {
                override fun onLoading(showMessage: String?) {
                    super.onLoading(showMessage)
                    alertDialog = AlertDialog.Builder(this@MainActivity).create()
                    alertDialog.show()
                }

                override fun onSuccess(data: MutableList<BannerBean?>?) {
                    super.onSuccess(data)
                    alertDialog.dismiss()
                    updateBanner(data)
                }

                override fun onCompleted() {
                    super.onCompleted()
                    alertDialog.dismiss()
                }
            })
        })
    }

    private fun initBanner() {
        binding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //这是给banner添加图片加载器
        binding.banner.setImageLoader(GlideImageLoader());
    }

    private fun updateBanner(data: MutableList<BannerBean?>?) {
        if (data.isNullOrEmpty()) {
            return;
        }
        val urls = ArrayList<String?>()
        val titles = ArrayList<String?>()

        data.forEach {
            urls.add(it?.imagePath);
            titles.add(it?.title);
        }

        binding.banner.setBannerTitles(titles);
        binding.banner.setImages(urls);
        binding.banner.start();
    }
}

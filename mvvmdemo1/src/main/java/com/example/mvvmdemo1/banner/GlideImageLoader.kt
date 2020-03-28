package com.example.mvvmdemo1.banner

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmdemo1.R
import com.youth.banner.loader.ImageLoader

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.banner
 * @ClassName: GlideImageLoader
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 16:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 16:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(
        context: Context,
        path: Any,
        imageView: ImageView
    ) {
        Glide.with(context).load(path).placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .centerCrop().into(imageView)
    }
}
package com.example.mvvmdemo1.base

import com.example.mvvmdemo1.bean.BannerBean

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.mvvmdemo1.base
 * @ClassName: ResponseResult
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/27 16:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/27 16:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ResponseResult<T> {
    var state: Int
    var errorMsg: String? = null
    var data: T? = null
    var error: Throwable? = null
    //这里和文件和进度有关了
    var precent: Int = 0 //文件下载百分比
    var total: Long = 0 //文件总大小

    constructor(state: Int, data: T, errorMsg: String?) {
        this.state = state
        this.errorMsg = errorMsg
        this.data = data
    }

    constructor(state: Int, error: Throwable?) {
        this.state = state
        this.error = error
    }

    constructor(state: Int, precent: Int, total: Long) {
        this.state = state
        this.precent = precent
        this.total = total
    }

    fun handler(callback: OnHandleCallback<T?>) {
        when (state) {
            LOADING -> callback.onLoading(errorMsg)
            SUCCESS -> callback.onSuccess(data)
            FAIL -> callback.onFailure(errorMsg)
            ERROR -> callback.onError(error)
            PROGRESS -> callback.onProgress(precent, total)
        }
        if (state != LOADING) {
            callback.onCompleted()
        }
    }

    //    public void handler(OnHandleCallback<T> callback, SmartRefreshLayout smartRefreshLayout) {
//        switch (state) {
//            case LOADING:
//            callback.onLoading(errorMsg);
//            break;
//            case SUCCESS:
//            callback.onSuccess(data);
//            smartRefreshLayout.finishRefresh();
//            smartRefreshLayout.finishLoadMore();
//            break;
//            case FAIL:
//            callback.onFailure(errorMsg);
//            smartRefreshLayout.finishRefresh(false);
//            smartRefreshLayout.finishLoadMore(false);
//            break;
//            case ERROR:
//            callback.onError(error);
//            smartRefreshLayout.finishRefresh(false);
//            smartRefreshLayout.finishLoadMore(false);
//            break;
//            case PROGRESS:
//            callback.onProgress(precent,total);
//            break;
//        }
//
//        if (state != LOADING) {
//            callback.onCompleted();
//        }
//    }


    companion object {
        //状态  这里有多个状态 0表示加载中；1表示成功；2表示联网失败；3表示接口虽然走通，但走的失败（如：关注失败）
        const val LOADING = 0
        const val SUCCESS = 1
        const val ERROR = 2
        const val FAIL = 3
        const val PROGRESS = 4 //注意只有下载文件和上传图片时才会有
        fun <T> loading(showMsg: String?): ResponseResult<T?> {
            return ResponseResult(LOADING, null, showMsg)
        }

        fun <T> success(data: T): ResponseResult<T> {
            return ResponseResult(SUCCESS, data, null)
        }

        fun <T> response(data: ResponModel<T>?): ResponseResult<T?> {
            return if (data != null) {
                if (data.isSuccess) {
                    ResponseResult(SUCCESS, data.data, null)
                } else ResponseResult<T?>(FAIL, null, data.errorMsg)
            } else ResponseResult<T?>(ERROR, null, null)
        }

        fun <T> failure(msg: String?): ResponseResult<T?> {
            return ResponseResult(ERROR, null, msg)
        }

        fun <T> error(t: Throwable?): ResponseResult<T> {
            return ResponseResult(ERROR, t)
        }

        fun <T> progress(precent: Int, total: Long): ResponseResult<T> {
            return ResponseResult(PROGRESS, precent, total)
        }
    }
}
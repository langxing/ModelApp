package com.example.common.http

import com.example.common.App
import com.example.common.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private typealias onError = (msg: String, code: Int) -> Unit
private typealias onSuccess<T> = (data: T) -> Unit

class HttpCallback<T> : Callback<T> {
    private lateinit var onSuccess: onSuccess<T>
    private lateinit var onError: onError

    /**
     * 是否由调用者自己处理
     */
    var selfHandle: Boolean = false

    override fun onFailure(call: Call<T>, t: Throwable) {
        val respThrowable = ExceptionHandle.handleServerException(t)
        onError.invoke(respThrowable.errMsg, -1)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val body = response.body()
        if (body is BaseResponse<*>) {
            if (body.code == 0) {
                if (!selfHandle) {
                    App.get().getApp().toast {
                        setText("请求成功~")
                    }
                }
                onSuccess.invoke(body)
            } else {
                if (!selfHandle) {
                    App.get().getApp().toast {
                        setText(body.msg)
                    }
                    ExceptionHandle.handleBusinessError(body.code)
                }
                onError.invoke(body.msg, body.code)
            }
        }
    }

    fun onError(error: onError) {
        this.onError = error
    }

    fun onSuccess(success: onSuccess<T>) {
        this.onSuccess = success
    }
}

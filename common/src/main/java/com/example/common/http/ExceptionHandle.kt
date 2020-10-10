package com.example.common.http

import android.net.ParseException
import com.example.common.App
import com.example.common.push
import com.example.common.ui.login.LoginActivity
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 *   @auther : Aleyn
 *   time   : 2019/08/12
 */
object ExceptionHandle {

    fun handleServerException(e: Throwable): ResponseThrowable {
        val ex: ResponseThrowable
        if (e is ResponseThrowable) {
            ex = e
        } else if (e is HttpException) {
            ex = ResponseThrowable(ServerError.HTTP_ERROR, e)
        } else if (e is JsonParseException
            || e is JSONException
            || e is ParseException || e is MalformedJsonException
        ) {
            ex = ResponseThrowable(ServerError.PARSE_ERROR, e)
        } else if (e is ConnectException) {
            ex = ResponseThrowable(ServerError.NETWORD_ERROR, e)
        } else if (e is javax.net.ssl.SSLException) {
            ex = ResponseThrowable(ServerError.SSL_ERROR, e)
        } else if (e is java.net.SocketTimeoutException) {
            ex = ResponseThrowable(ServerError.TIMEOUT_ERROR, e)
        } else if (e is java.net.UnknownHostException) {
            ex = ResponseThrowable(ServerError.TIMEOUT_ERROR, e)
        } else {
            ex = if (!e.message.isNullOrEmpty()) ResponseThrowable(1000, e.message!!, e)
            else ResponseThrowable(ServerError.UNKNOWN, e)
        }
        return ex
    }

    fun handleBusinessError(code: Int) {
        when (code) {
            BusinessError.UNLOGIN.code -> {
                App.get()
                    .getApp()
                    .push<LoginActivity>()
            }
        }
    }
}
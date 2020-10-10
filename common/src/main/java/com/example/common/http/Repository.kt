package com.example.common.http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

suspend fun <T> request(call: () -> Call<BaseResponse<T>>): Call<BaseResponse<T>> {
    return withContext(Dispatchers.IO) {
        call.invoke()
    }
}
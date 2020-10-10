package com.example.common.http

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("errorCode") val code: Int,
    @SerializedName("errorMsg") val msg: String,
    @SerializedName("data") val data: T
)

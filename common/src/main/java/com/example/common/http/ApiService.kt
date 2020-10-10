package com.example.common.http

import com.example.common.base.Banner
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("banner/json")
    fun getBanner(): Call<BaseResponse<List<Banner>>>
}
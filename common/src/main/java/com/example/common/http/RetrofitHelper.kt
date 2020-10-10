package com.example.common.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitHelper private constructor() {
    private val map = HashMap<String, Retrofit>()
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .callTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    companion object {
        private val instance by lazy {
            RetrofitHelper()
        }

        fun get() = instance
    }

    fun create(baseUrl: String = "https://www.wanandroid.com/"): Retrofit {
        return if (map.containsKey(baseUrl)) {
            map[baseUrl]!!
        } else {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            map[baseUrl] = retrofit
            return retrofit
        }
    }
}
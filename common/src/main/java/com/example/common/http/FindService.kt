package com.example.common.http

import kotlin.reflect.KProperty

class FindService constructor(val baseUrl: String = "https://www.wanandroid.com/") {

    inline operator fun <reified T> getValue(thisRef: Any, property: KProperty<*>): T {
        return RetrofitHelper.get().create(baseUrl).create(T::class.java)
    }

}

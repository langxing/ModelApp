package com.example.common.http

enum class BusinessError(val code: Int, val msg: String) {

    UNLOGIN(-1001, "请先登录！")
}
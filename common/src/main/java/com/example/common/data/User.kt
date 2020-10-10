package com.example.common.data

data class User(
    val userName: String = "张三",
    var account: String = "",
    var password: String = "",
    val sex: Int = 0,
    val age: Int = 18
)
package com.example.common.data

sealed class Result {

}

/**
 * 请求成功
 */
data class Success(val data: Any) : Result()

/**
 * 请求失败
 */
sealed class Failure(val msg: String, val code: Int) : Result() {
    data class NetworkFailure(var failureMsg: String = "网络错误", var failureCode: Int = 101) : Failure(failureMsg, failureCode)
    data class BusinessFailure(var loginMsg: String = "登录失败", var loginCode: Int = 999): Failure(loginMsg, loginCode)
}
package com.example.common.http

/**
 *   @auther : Aleyn
 *   time   : 2019/08/12
 */
class ResponseThrowable : Exception {
    var code: Int
    var errMsg: String

    constructor(error: ServerError, e: Throwable? = null) : super(e) {
        code = error.getKey()
        errMsg = error.getValue()
    }

    constructor(code: Int, msg: String, e: Throwable? = null) : super(e) {
        this.code = code
        this.errMsg = msg
    }

    constructor(base: BaseResponse<*>, e: Throwable? = null) : super(e) {
        this.code = base.code
        this.errMsg = base.msg
    }
}


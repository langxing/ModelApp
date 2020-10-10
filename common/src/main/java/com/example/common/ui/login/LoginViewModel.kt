package com.example.common.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.data.Failure
import com.example.common.data.Result
import com.example.common.data.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    fun login(account: String, password: String, callback: (result: Result) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            callback.invoke(requestLogin(account, password))
        }
    }

    private suspend fun requestLogin(account: String, password: String): Result {
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (account == "abc" && password == "123") {
                Success("登录成功~")
            } else {
                Failure.BusinessFailure("登录失败~", 999)
            }
        }
    }
}
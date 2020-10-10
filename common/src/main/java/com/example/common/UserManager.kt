package com.example.common

import android.app.Activity
import android.content.Context
import androidx.databinding.ObservableBoolean
import com.example.common.ui.login.LoginActivity

class UserManager private constructor() {
    private val isLogin = ObservableBoolean(false)

    companion object {
        private val instance: UserManager by lazy {
            UserManager()
        }

        fun get() = instance
    }

    fun refreshLogin(login: Boolean) {
        isLogin.set(login)
    }

    fun checkLogin(context: Context, onLogin: () -> Unit) {
        if (isLogin.get()) {
            onLogin.invoke()
        } else {
            if (context is Activity) {
                context.push<LoginActivity>(params = *arrayOf("id" to "0"))
            } else {
                context.push<LoginActivity>()
            }
        }
    }

}
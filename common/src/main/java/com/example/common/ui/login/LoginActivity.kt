package com.example.common.ui.login

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.common.R
import com.example.common.UserManager
import com.example.common.data.Failure
import com.example.common.data.Success
import com.example.common.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : Activity() {
    private val model = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            if (editAccount.text.isNullOrEmpty() || editPassword.text.isNullOrEmpty()) {
                toast {
                    setText("用户名和密码不能为空")
                }
            } else {
                model.login(editAccount.text.toString(), editPassword.text.toString()) {
                    when (it) {
                        is Success -> {
                            Log.e("onSuccess", "data=${it.data}")
                            UserManager.get().refreshLogin(true)
                            toast {
                                setText("登录成功~")
                            }
                            finish()
                        }
                        is Failure -> {
                            Log.e("onFailure", "msg=${it.msg};code=${it.code}")
                            toast {
                                setText("登录失败，请重试~")
                            }
                        }
                    }
                }
            }
        }
    }
}
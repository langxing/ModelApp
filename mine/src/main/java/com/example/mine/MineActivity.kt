package com.example.mine

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.common.base.BaseActivity
import com.example.common.data.User
import com.example.common.toast
import com.example.router.ShareService
import com.example.router.UserService
import io.github.prototypez.appjoint.AppJoint
import kotlinx.android.synthetic.main.activity_mine.*
import kotlinx.coroutines.*

class MineActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val title = intent.getStringExtra("title")
        setContentView(R.layout.activity_mine)
        UserServiceImpl.data.observe(this, Observer {
            val user = it as User?
            txtName.text = "用户信息：${user?.userName}-->$title"
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        AppJoint.service(ShareService::class.java).transferData("返回")
        finish()
    }

    /**
     * 执行一个iO任务，并挂起
     *
     * suspend：强制在协程中调用此函数
     * withContext：将操作切换到指定线程
     */
    private suspend fun ioTask() {
        withContext(Dispatchers.IO) {
            Log.e("io", "io任务执行")
            delay(1000)
        }
    }

    private fun switchUI(msg: String = "") {
        Log.e("ui", "ui任务执行")
        toast {
            setText("${msg}执行完毕")
        }
    }
}
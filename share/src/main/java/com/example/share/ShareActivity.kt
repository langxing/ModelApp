package com.example.share

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.common.base.BaseActivity
import com.example.common.UserManager
import com.example.common.data.User
import com.example.common.push
import com.example.common.toast
import com.example.share.home.HomeActivity
import io.github.prototypez.appjoint.AppJoint
import kotlinx.android.synthetic.main.activity_share.*

class ShareActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        val service = ShareAppImpl.userService
        ShareServiceImpl.data.observe(this, Observer {
            toast {
                setText(it.toString())
            }
        })
        btnShare.setOnClickListener {
//            push<HomeActivity>()
            UserManager.get().checkLogin(this) {
                service.transferData(User(userName = "科技美学"))
                service.openMineActivity(this, 100, *arrayOf("title" to "个人中心"))
            }
        }
    }

}

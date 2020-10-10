package com.example.share

import android.app.Application
import com.example.common.IBaseApp
import com.example.router.UserService
import io.github.prototypez.appjoint.AppJoint

class ShareAppImpl private constructor() : IBaseApp {
    private lateinit var application: Application

    override fun initApp(app: Application) {
        application = app
    }

    override fun getApp(): Application {
        return application
    }

    companion object {
        private val instance: ShareAppImpl by lazy {
            ShareAppImpl()
        }

        @JvmStatic
        fun get() = instance

        @JvmStatic
        var userService: UserService = AppJoint.service(UserService::class.java)
    }

}
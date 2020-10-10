package com.example.common

import android.app.Application

class App private constructor() : IBaseApp {
    private lateinit var application: Application

    companion object {
        private val instance: App by lazy {
            App()
        }

        fun get() = instance
    }

    override fun initApp(app: Application) {
        application = app
    }

    override fun getApp(): Application {
        return application
    }
}
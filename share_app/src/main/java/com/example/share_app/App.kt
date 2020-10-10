package com.example.share_app

import android.app.Application
import com.example.share.ShareAppImpl.Companion.get

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        get().initApp(this)
    }
}
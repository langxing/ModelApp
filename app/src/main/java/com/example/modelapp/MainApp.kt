package com.example.modelapp

import android.app.Application
import com.example.common.App

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        App.get().initApp(this)
    }
}
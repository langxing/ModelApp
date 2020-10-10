package com.example.common

import android.app.Application

interface IBaseApp {

    fun initApp(app: Application)

    fun getApp(): Application
}
package com.example.common.base

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar

open class BaseActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ImmersionBar.with(this)
            .statusBarColor(Color.parseColor("#00000000"))
            .init()
    }
}
package com.example.share_app

import android.os.Bundle
import com.example.common.base.BaseActivity
import com.example.common.push
import com.example.share.ShareActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        push<ShareActivity>()
    }
}
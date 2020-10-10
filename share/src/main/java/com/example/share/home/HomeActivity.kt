package com.example.share.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.example.common.R
import com.example.common.base.BaseActivity
import com.example.common.showDialog
import com.example.common.toast

class HomeActivity : BaseActivity() {
    private val model = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val dialog = showDialog {
            val contentView = LayoutInflater.from(this@HomeActivity).inflate(R.layout.include_loading, null)
            setContentView(contentView)
        }
        model.getBanner()
            .observe(this, Observer {
                dialog.dismiss()
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val data = data?.getStringExtra("msg")
            data?.let {
                toast {
                    setText(it)
                }
            }
        }
    }
}
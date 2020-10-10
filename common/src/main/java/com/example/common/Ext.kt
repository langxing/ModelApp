package com.example.common

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.common.http.HttpCallback
import okhttp3.OkHttpClient
import retrofit2.Call
import java.io.Serializable

inline fun <reified T> Activity.push(requestCode: Int = 0, vararg params: Pair<String, Any>) {
    val intent = Intent(this, T::class.java)
    params.forEach {
        when (it.second) {
            is String -> {
                intent.putExtra(it.first, it.second as String)
            }
            is Int -> {
                intent.putExtra(it.first, it.second as Int)
            }
            is Double -> {
                intent.putExtra(it.first, it.second as Double)
            }
            is Float -> {
                intent.putExtra(it.first, it.second as Float)
            }
            is Long -> {
                intent.putExtra(it.first, it.second as Long)
            }
            is Boolean -> {
                intent.putExtra(it.first, it.second as Boolean)
            }
            is Parcelable -> {
                intent.putExtra(it.first, it.second as Parcelable)
            }
            is Serializable -> {
                intent.putExtra(it.first, it.second as Serializable)
            }
            else -> {

            }
        }
    }
    if (requestCode != 0) {
        startActivityForResult(intent, requestCode)
    } else {
        startActivity(intent)
    }
}

inline fun <reified T> Context.push(flag: Int = Intent.FLAG_ACTIVITY_SINGLE_TOP, vararg params: Pair<String, Any>) {
    val intent = Intent(this, T::class.java)
    params.forEach {
        when (it.second) {
            is String -> {
                intent.putExtra(it.first, it.second as String)
            }
            is Int -> {
                intent.putExtra(it.first, it.second as Int)
            }
            is Double -> {
                intent.putExtra(it.first, it.second as Double)
            }
            is Float -> {
                intent.putExtra(it.first, it.second as Float)
            }
            is Long -> {
                intent.putExtra(it.first, it.second as Long)
            }
            is Boolean -> {
                intent.putExtra(it.first, it.second as Boolean)
            }
            is Parcelable -> {
                intent.putExtra(it.first, it.second as Parcelable)
            }
            is Serializable -> {
                intent.putExtra(it.first, it.second as Serializable)
            }
            else -> {

            }
        }
    }
    intent.flags = flag
    startActivity(intent)
}

fun Context.toast(block: Toast.() -> Unit) {
    val toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.block()
    toast.show()
}

fun <T> Call<T>.callback(block: HttpCallback<T>.() -> Unit) {
    val httpCallback = HttpCallback<T>()
    enqueue(httpCallback)
    httpCallback.block()
}

fun Activity.showDialog(block: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.block()
    val dialog = builder.create()
    dialog.show()
    return dialog
}





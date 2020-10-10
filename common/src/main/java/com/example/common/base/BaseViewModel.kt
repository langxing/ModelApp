package com.example.common.base

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.viewModelScope
import com.example.common.App
import com.example.common.http.BaseResponse
import com.example.common.http.request
import kotlinx.coroutines.*

open class BaseViewModel : AndroidViewModel(App.get().getApp()), LifecycleObserver {

    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch(Dispatchers.Main) {
        withTimeout(10000) {
            block()
        }
    }
}
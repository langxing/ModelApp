package com.example.share.home

import androidx.lifecycle.LiveData
import com.example.common.base.Banner
import com.example.common.base.BaseViewModel
import com.example.common.callback
import com.example.common.event.SingleLiveEvent
import com.example.common.http.ApiService
import com.example.common.http.FindService
import com.example.common.http.request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {
    private val service: ApiService by FindService()

    private val data = SingleLiveEvent<List<Banner>>()

    fun getBanner(): LiveData<List<Banner>> {
        launchUI {
            withContext(Dispatchers.Main) {
                request {
                    service.getBanner()
                }.callback {
                selfHandle = false
                onSuccess {
                    data.value = it.data
                }
                }
            }
        }
        return data
    }
}
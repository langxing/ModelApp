package com.example.share

import com.example.common.event.SingleLiveEvent
import com.example.router.ShareService
import io.github.prototypez.appjoint.core.ServiceProvider

@ServiceProvider
class ShareServiceImpl : ShareService {

    override fun transferData(data: Any) {
        ShareServiceImpl.data.value = data
    }

    companion object {
        val data = SingleLiveEvent<Any>()
    }
}
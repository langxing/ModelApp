package com.example.mine

import com.example.common.base.BaseActivity
import com.example.common.event.SingleLiveEvent
import com.example.common.push
import com.example.router.UserService
import io.github.prototypez.appjoint.core.ServiceProvider

@ServiceProvider
class UserServiceImpl : UserService {

    override fun openMineActivity(activity: BaseActivity, requestCode: Int, vararg params: Pair<String, Any>) {
        activity.push<MineActivity>(requestCode, *params)
    }

    override fun transferData(data: Any) {
        UserServiceImpl.data.value = data
    }

    companion object {
        val data = SingleLiveEvent<Any>()
    }
}
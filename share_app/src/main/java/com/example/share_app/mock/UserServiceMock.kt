package com.example.share_app.mock

import com.example.common.base.BaseActivity
import com.example.router.UserService
import io.github.prototypez.appjoint.core.ServiceProvider

@ServiceProvider
class UserServiceMock : UserService {

    override fun openMineActivity(
        activity: BaseActivity,
        requestCode: Int,
        vararg params: Pair<String, Any>
    ) {

    }

    override fun transferData(data: Any) {

    }

}
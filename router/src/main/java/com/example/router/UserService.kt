package com.example.router

import com.example.common.base.BaseActivity
import com.example.common.data.User

interface UserService {

    fun openMineActivity(activity: BaseActivity, requestCode: Int, vararg params: Pair<String, Any>)

    fun transferData(data: Any)
}
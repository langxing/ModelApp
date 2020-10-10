package com.example.common.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar

open class BaseFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ImmersionBar.with(this).init()
    }
}
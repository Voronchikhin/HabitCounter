package com.example.neofr.habitcounter.view

import android.support.v4.app.Fragment
import com.example.neofr.habitcounter.view.base.SingleFragmentActivity

class FeedActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = FeedFragment()
}

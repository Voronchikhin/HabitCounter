package com.example.neofr.habitcounter.view


import android.support.v4.app.Fragment
import com.example.neofr.habitcounter.view.base.SingleFragmentActivity

class HabitActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = HabitFragment()
}

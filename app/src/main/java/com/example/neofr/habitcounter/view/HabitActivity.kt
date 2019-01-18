package com.example.neofr.habitcounter.view


import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.neofr.habitcounter.R
import com.example.neofr.habitcounter.view.base.SingleFragmentActivity

class HabitActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = HabitFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}

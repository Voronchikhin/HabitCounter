package com.example.neofr.habitcounter.view.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.neofr.habitcounter.R

abstract class SingleFragmentActivity : AppCompatActivity() {
    protected abstract fun createFragment(): Fragment
    protected var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentManager = supportFragmentManager
        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment == null) {
            fragment = createFragment()
            fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
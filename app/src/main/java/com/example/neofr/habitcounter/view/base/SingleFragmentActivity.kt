package com.example.neofr.habitcounter.view.base


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.neofr.habitcounter.R
import com.example.neofr.habitcounter.SettingsFragment

abstract class SingleFragmentActivity : AppCompatActivity() {
    protected abstract fun createFragment(): Fragment
    protected var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentManager = supportFragmentManager
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.menu.add("settings").setOnMenuItemClickListener {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, SettingsFragment()).commit()
            true
        }
        navigationView.menu.add("main").setOnMenuItemClickListener {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
            true
        }
        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment == null) {
            fragment = createFragment()
            fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
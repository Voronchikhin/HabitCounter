package com.example.neofr.habitcounter.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.neofr.habitcounter.presenter.HabitPresenter
import com.example.neofr.habitcounter.presenter.common.UseCaseHandler
import com.example.neofr.habitcounter.view.base.SingleFragmentActivity

class FeedActivity : SingleFragmentActivity() {
    private lateinit var habitPresenter: HabitPresenter
    private lateinit var habitView: IHabitView

    override fun createFragment(): Fragment = FeedFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        habitView = fragment as IHabitView
        habitPresenter = HabitPresenter(habitView, UseCaseHandler())
        habitView.presenter = habitPresenter
    }
}

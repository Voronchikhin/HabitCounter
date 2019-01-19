package com.example.neofr.habitcounter.view

import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.presenter.HabitPresenter
import com.example.neofr.habitcounter.presenter.common.View

interface IHabitView : View<HabitPresenter> {
    fun showHabits(habits: Collection<HabitCounter>)
    fun updateHabit(habitCounter: HabitCounter)
    fun showError()
}
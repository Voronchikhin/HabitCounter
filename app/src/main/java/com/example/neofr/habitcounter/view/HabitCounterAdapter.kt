package com.example.neofr.habitcounter.view

import com.example.neofr.habitcounter.model.HabitCounter

interface HabitCounterAdapter {
    fun modelToView(habitCounter: HabitCounter, view: HabitView)
}
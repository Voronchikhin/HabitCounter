package com.example.neofr.habitcounter.dao

import com.example.neofr.habitcounter.model.HabitCounter


interface HabitCounterRepository {
    fun getHabitCounters(getCountersCallBack: GetCountersCallBack)
    fun updateHabitCounter(habitCounter: HabitCounter, updateHabitCallBack: UpdateHabitCallBack) // could update exists habit
}

interface GetCountersCallBack {
    fun onCountersLoaded(counters: Collection<HabitCounter>)
    fun onError()
}

interface UpdateHabitCallBack {
    fun onAddHabit(addedCounter: HabitCounter)
}
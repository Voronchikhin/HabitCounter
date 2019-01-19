package com.example.neofr.habitcounter.model

import java.util.*

class HabitCounterRepositoryImpl(private val habitDataSource: HabitDataSource) : HabitCounterRepository {
    override fun getHabitCounters(getCountersCallBack: GetCountersCallBack) {
        habitDataSource.getHabitCounters(getCountersCallBack)
    }

    override fun addHabitCounter(habitCounter: HabitCounter, addHabitCallBack: AddHabitCallBack) {
        habitDataSource.addHabitCounter(habitCounter, addHabitCallBack)
    }

    override fun findHabitCounter(habitName: String, findHabitCallBack: FindHabitCallBack) {
        habitDataSource.findHabitCounter(habitName, findHabitCallBack)
    }

    companion object {
        val instance = HabitCounterRepositoryImpl(FakeHabitDataSourceImpl())
    }

    private val habits = HashMap<String,HabitCounter>()
}
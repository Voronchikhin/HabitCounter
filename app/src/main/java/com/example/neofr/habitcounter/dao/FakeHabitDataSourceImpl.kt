package com.example.neofr.habitcounter.dao

import com.example.neofr.habitcounter.model.Habit
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.model.Resource

class FakeHabitDataSourceImpl : HabitDataSource {
    override fun getHabitCounters(getCountersCallBack: GetCountersCallBack) {
        getCountersCallBack.onCountersLoaded(habits.values)
    }

    override fun addHabitCounter(habitCounter: HabitCounter, addHabitCallBack: AddHabitCallBack) {
        addHabitCounter(habitCounter)
        addHabitCallBack.onAddHabit(habitCounter)
    }

    override fun findHabitCounter(habitName: String, findHabitCallBack: FindHabitCallBack) {
        val habit = habits[habitName]
        if (habit != null) {
            findHabitCallBack.onFindHabitCallBack(habit)
            return
        }
        findHabitCallBack.onError()
    }

    val habits = HashMap<String, HabitCounter>()

    init {
        val smokingHabit = Habit("smoking", "smoke siggarettes")
        val drinkHabit = Habit("drinking", "drinking vodka, beer and so on")
        val timeResource = Resource("Time")
        val moneyResource = Resource("Money")

        val drinkHabitCounter = HabitCounter(smokingHabit)
        val smokeHabitCounter = HabitCounter(drinkHabit)

        drinkHabitCounter.addResource(timeResource, 5 * 60, 0)
        drinkHabitCounter.addResource(moneyResource, 500, 0)

        smokeHabitCounter.addResource(timeResource, 60 * 60, 0)
        smokeHabitCounter.addResource(moneyResource, 150, 0)

        addHabitCounter(drinkHabitCounter)
        addHabitCounter(smokeHabitCounter)
    }

    private fun addHabitCounter(habitCounter: HabitCounter) {
        habits[habitCounter.habit.name] = habitCounter
    }
}
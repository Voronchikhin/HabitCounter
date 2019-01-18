package com.example.neofr.habitcounter.model

import java.util.*

class HabitCounterRepositoryImpl : HabitCounterRepository {
    override fun getHabitCounters(): Collection<HabitCounter> {
        return habits.values
    }

    override fun addHabitCounter(habitCounter: HabitCounter) {
        habits[habitCounter.habit.name] = habitCounter
    }

    override fun findHabitCounter(habitName: String): HabitCounter? {
        return habits[habitName]
    }
    companion object {
        val instance = HabitCounterRepositoryImpl()
    }
    private val habits = HashMap<String,HabitCounter>()
}
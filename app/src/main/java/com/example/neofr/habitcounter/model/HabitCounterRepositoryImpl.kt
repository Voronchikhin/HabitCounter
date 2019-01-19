package com.example.neofr.habitcounter.model

import java.util.*

class HabitCounterRepositoryImpl(val habitDataSource: HabitDataSource) : HabitCounterRepository {
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
        val instance = HabitCounterRepositoryImpl(HabitDataSourceImpl())
    }

    private val habits = HashMap<String,HabitCounter>()

    init {
        val smokingHabit = Habit("Smoking", "smoke siggarettes")
        val drinkHabit = Habit("Drink Alcohol", "drinking vodka, beer and so on")
        val timeResource = Resource("Time")
        val moneyResource = Resource("Money")

        val drinkHabitCounter = HabitCounter(smokingHabit)
        val smokeHabitCounter = HabitCounter(drinkHabit)

        drinkHabitCounter.addResource(timeResource,5*60,0)
        drinkHabitCounter.addResource(moneyResource, 500, 0)

        smokeHabitCounter.addResource(timeResource, 60*60, 0)
        smokeHabitCounter.addResource(moneyResource, 150, 0)

        addHabitCounter(drinkHabitCounter)
        addHabitCounter(smokeHabitCounter)
    }
}
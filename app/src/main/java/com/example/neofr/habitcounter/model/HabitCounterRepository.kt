package com.example.neofr.habitcounter.model


interface HabitCounterRepository {
    fun getHabitCounters(): Collection<HabitCounter>
    fun addHabitCounter(habitCounter: HabitCounter)
    fun findHabitCounter(habitName: String) : HabitCounter?
}
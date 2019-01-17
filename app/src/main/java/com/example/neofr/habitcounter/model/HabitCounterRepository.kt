package com.example.neofr.habitcounter.model


//TODO: добавить имплементацию()
interface HabitCounterRepository {
    fun getHabitCounters(): Collection<HabitCounter>
    fun addHabitCounter()
    fun findHabitCounter(habitName: String) : HabitCounter
}
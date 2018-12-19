package com.example.neofr.habitcounter.model

class HabitCounterFactory {
    fun createHabit(number : Int):HabitCounter{
        return HabitCounter(Habit("Habit descr # $number","Habit #$number")
            , mapOf(Pair(Resource("Resource",92), 1)))
    }
}

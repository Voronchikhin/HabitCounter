package com.example.neofr.habitcounter.model

import com.example.neofr.habitcounter.model.dto.Habit

data class HabitCounter(
    val habit: Habit,
    val resourceCounters: List<ResourceAndCounter>
){
    fun doCount(){
        resourceCounters.forEach{it.resourceCounter.count+=it.resourceCounter.increment}
    }
}
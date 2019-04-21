package com.example.neofr.habitcounter.model

import android.arch.persistence.room.Entity

@Entity
data class HabitCounter(
    val habit: Habit?,
    val resourceCounters : List<ResourceCounter>
) {
    fun doCount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
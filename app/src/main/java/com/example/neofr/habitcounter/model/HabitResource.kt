package com.example.neofr.habitcounter.model

import android.arch.persistence.room.Entity

@Entity
data class HabitResource (
    val habitId: Long,
    val resourceId: Long
)
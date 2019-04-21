package com.example.neofr.habitcounter.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val description: String
)

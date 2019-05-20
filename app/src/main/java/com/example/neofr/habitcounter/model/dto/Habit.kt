package com.example.neofr.habitcounter.model.dto

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Habit(
    val name: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

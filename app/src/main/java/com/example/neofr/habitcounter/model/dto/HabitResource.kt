package com.example.neofr.habitcounter.model.dto

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(primaryKeys = ["habitId", "resourceId"], foreignKeys = [
    ForeignKey(entity = Habit::class, parentColumns = ["id"], childColumns =["habitId"] ),
    ForeignKey(entity = Resource::class, parentColumns = ["id"], childColumns =["resourceId"] )
])
data class HabitResource (
    val habitId: Long,
    val resourceId: Long
)
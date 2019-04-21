package com.example.neofr.habitcounter.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Resource(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name: String,
    val description : String
)
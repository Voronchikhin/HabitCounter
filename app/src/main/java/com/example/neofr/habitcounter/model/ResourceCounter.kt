package com.example.neofr.habitcounter.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Relation

@Entity
data class ResourceCounter (
    @Embedded
    val resource: Resource,
    val count: Long
)

package com.example.neofr.habitcounter.model.dto

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = Resource::class, parentColumns = ["id"], childColumns = ["resourceId"])
    ]
)
data class ResourceCounter (
    val resourceId: Long,
    var count: Long,
    val increment: Long
){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}

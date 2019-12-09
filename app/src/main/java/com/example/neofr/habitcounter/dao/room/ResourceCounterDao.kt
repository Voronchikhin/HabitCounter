package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.dto.ResourceCounter

@Dao
interface ResourceCounterDao {
    @Query("SELECT * FROM RESOURCECOUNTER")
    fun getAll(): List<ResourceCounter>

    @Query("SELECT * FROM ResourceCounter WHERE resourceId = :resourceId")
    fun getByResourceId(resourceId : Long) : ResourceCounter

    @Insert
    fun insert(vararg ResourceCounter: ResourceCounter)

    @Update
    fun update(vararg ResourceCounter: ResourceCounter)

    @Delete
    fun delete(vararg ResourceCounter: ResourceCounter)
}
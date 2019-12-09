package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.dto.HabitResource

@Dao
interface HabitResourceDao {
    @Query("SELECT * FROM HabitResource")
    fun getAll(): List<HabitResource>

    @Query("SELECT * FROM HabitResource WHERE habitId = :habitId")
    fun getByHabitId(habitId: Long) : List<HabitResource>

    @Query("SELECT * FROM HABITRESOURCE WHERE resourceId = :resourceId")
    fun getByResourceId(resourceId : Long) : List<HabitResource>

    @Insert
    fun insert(vararg habitResource: HabitResource)

    @Update
    fun update(vararg habitResource: HabitResource)

    @Delete
    fun delete(vararg habitResource: HabitResource)
}
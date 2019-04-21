package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.neofr.habitcounter.model.HabitCounter

interface HabitCounterDao {
    @Query("SELECT * FROM HABITCOUNTER")
    fun getAll(): List<HabitCounter>

    @Query("SELECT * FROM HABIT WHERE name= :name")
    fun getByName(name: String): HabitCounter

    @Query("SELECT * FROM HABIT WHERE id= :id")
    fun getById(id: Long): HabitCounter

    @Insert
    fun insert(habit: HabitCounter)

    @Update
    fun update(habit: HabitCounter)

    @Delete
    fun delete(habit: HabitCounter)
}
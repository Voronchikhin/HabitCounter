package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.Habit


@Dao
interface HabitDAO {
    @Query("SELECT * FROM HABIT")
    fun getAll(): List<Habit>

    @Query("SELECT * FROM HABIT WHERE name= :name")
    fun getByName(name: String): Habit

    @Query("SELECT * FROM HABIT WHERE id= :id")
    fun getById(id: Long): Habit

    @Insert
    fun insert(habit: Habit)

    @Update
    fun update(habit: Habit)

    @Delete
    fun delete(habit: Habit)
}
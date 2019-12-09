package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.dto.Habit


@Dao
interface HabitDao {
    @Query("SELECT * FROM HABIT")
    fun getAll(): List<Habit>

    @Query("SELECT * FROM HABIT WHERE name= :name")
    fun getByName(name: String): Habit

    @Query("SELECT * FROM HABIT WHERE id= :id")
    fun getById(id: Long): Habit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg habit: Habit)

    @Update
    fun update(vararg habit: Habit)

    @Delete
    fun delete(vararg habit: Habit)
}
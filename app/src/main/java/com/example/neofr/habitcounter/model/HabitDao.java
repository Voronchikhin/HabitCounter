package com.example.neofr.habitcounter.model;

import android.arch.persistence.room.*;

import java.util.List;

@Dao
public interface HabitDao {
    @Query("SELECT * FROM HABIT")
    List<Habit> getAll();

    @Query("SELECT * FROM HABIT WHERE name= :name")
    Habit getByName(String name);

    @Query("SELECT * FROM HABIT WHERE id= :id")
    Habit getById(long id);

    @Insert
    void insert(Habit habit);

    @Update
    void update(Habit habit);

    @Delete
    void delete(Habit habit);
}

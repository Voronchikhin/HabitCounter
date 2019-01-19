package com.example.neofr.habitcounter.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Habit.class}, version = 1)
public abstract class KotlinLicksAss extends RoomDatabase {
    public abstract HabitDao habitDao();
}

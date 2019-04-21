package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.neofr.habitcounter.model.Habit
import com.example.neofr.habitcounter.model.HabitCounter

@Database(entities = [Habit::class, HabitCounter::class] ,version = 1)
abstract class HabitDB: RoomDatabase() {
    companion object {
        private var INSTANCE: HabitDB? = null

        fun getInstance(context: Context): HabitDB? {
            if (INSTANCE == null) {
                synchronized(HabitDB::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        HabitDB::class.java, "habit.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.neofr.habitcounter.dao.HabitDataSource
import com.example.neofr.habitcounter.model.dto.Habit
import com.example.neofr.habitcounter.model.dto.HabitResource
import com.example.neofr.habitcounter.model.dto.Resource
import com.example.neofr.habitcounter.model.dto.ResourceCounter
import java.util.concurrent.Executors

@Database(entities = [Habit::class, HabitResource::class, Resource::class, ResourceCounter::class], version = 2)
abstract class HabitDB : RoomDatabase() {
    abstract val habitDao: HabitDao
    abstract val resourceDao: ResourceDao
    abstract val resourceCounterDao: ResourceCounterDao
    abstract val habitResourceDao: HabitResourceDao

    companion object {
        private var INSTANCE: HabitDB? = null

        fun getInstance(context: Context): HabitDB? {
            if (INSTANCE == null) {
                synchronized(HabitDB::class) {
                    INSTANCE = createDb(context)
                }
            }
            return INSTANCE
        }

        private fun createDb(context: Context): HabitDB {
            return Room.databaseBuilder(
                context.applicationContext,
                HabitDB::class.java, "habit_counter.db"
            ).allowMainThreadQueries()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        Executors.newSingleThreadExecutor().execute {
                            Thread.sleep(1000)
                            getInstance(context)?.resourceDao?.insert(*HabitDataSource.MEMORY_DATA_SOURCE.getResources().toTypedArray())
                            getInstance(context)?.habitDao?.insert(*HabitDataSource.MEMORY_DATA_SOURCE.getHabits().toTypedArray())
                            getInstance(context)?.resourceCounterDao?.insert(*HabitDataSource.MEMORY_DATA_SOURCE.getResourceCounters().toTypedArray())
                            getInstance(context)?.habitResourceDao?.insert(*HabitDataSource.MEMORY_DATA_SOURCE.getHabitResources().toTypedArray())
                        }
                    }
                })
                .build()
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
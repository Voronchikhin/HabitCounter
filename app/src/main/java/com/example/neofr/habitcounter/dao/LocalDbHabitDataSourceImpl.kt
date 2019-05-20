package com.example.neofr.habitcounter.dao

import android.content.Context
import com.example.neofr.habitcounter.dao.room.HabitDB
import com.example.neofr.habitcounter.model.dto.Habit
import com.example.neofr.habitcounter.model.dto.HabitResource
import com.example.neofr.habitcounter.model.dto.Resource
import com.example.neofr.habitcounter.model.dto.ResourceCounter

class LocalDbHabitDataSourceImpl(context: Context) : HabitDataSource {
    override fun updateResource(resource: Resource) {
        habitDB?.resourceDao?.update(resource)
    }

    override fun updateHabit(habit: Habit) {
        habitDB?.habitDao?.update(habit)
    }

    override fun updateHabitResource(habitResource: HabitResource) {
        habitDB?.habitResourceDao?.update(habitResource)
    }

    override fun updateResourceCounter(resourceCounter: ResourceCounter) {
        habitDB?.resourceCounterDao?.update(resourceCounter)
    }

    val habitDB = HabitDB.getInstance(context)

    override fun getHabits(): List<Habit> = habitDB?.habitDao?.getAll() ?: emptyList()

    override fun getResourceCounters(): List<ResourceCounter> =
        habitDB?.resourceCounterDao?.getAll() ?: emptyList()

    override fun getResources(): List<Resource> = habitDB?.resourceDao?.getAll() ?: emptyList()

    override fun getHabitResourceByHabitId(habitId: Long): List<HabitResource> =
        habitDB?.habitResourceDao?.getByHabitId(habitId) ?: emptyList()

    override fun getHabitResources(): List<HabitResource> =
        habitDB?.habitResourceDao?.getAll() ?: emptyList()

    override fun getResourceById(resourceId: Long): Resource? =
        habitDB?.resourceDao?.getById(resourceId)

    override fun getResourceCounterByResourceId(resourceId: Long): ResourceCounter? =
        habitDB?.resourceCounterDao?.getByResourceId(resourceId)
}
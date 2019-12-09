package com.example.neofr.habitcounter.dao

import com.example.neofr.habitcounter.model.dto.Habit
import com.example.neofr.habitcounter.model.dto.HabitResource
import com.example.neofr.habitcounter.model.dto.Resource
import com.example.neofr.habitcounter.model.dto.ResourceCounter

interface HabitDataSource {
    fun getHabits(): List<Habit>
    fun getResourceCounters() : List<ResourceCounter>
    fun getResources(): List<Resource>
    fun getHabitResourceByHabitId(habitId: Long): List<HabitResource>

    fun getHabitResources() : List<HabitResource>
    fun getResourceById(resourceId: Long): Resource?
    fun getResourceCounterByResourceId(resourceId: Long): ResourceCounter?
    fun updateResource(resource: Resource)
    fun updateHabit(habit: Habit)
    fun updateHabitResource(habitResource: HabitResource)
    fun updateResourceCounter(resourceCounter: ResourceCounter)


    companion object {
        val MEMORY_DATA_SOURCE = object : HabitDataSource {
            override fun updateResource(resource: Resource) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun updateHabit(habit: Habit) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun updateHabitResource(habitResource: HabitResource) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun updateResourceCounter(resourceCounter: ResourceCounter) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getResourceCounters(): List<ResourceCounter> = resourceCounters

            override fun getResources(): List<Resource> = resources

            override fun getHabitResources(): List<HabitResource> = habitResources

            private val habits = listOf(
                Habit( "Smoke", "Smoke cigarettes").apply { id=1 },
                Habit( "Coffee", "drink coffee").apply { id=2 }
            )

            private val resources = listOf(
                Resource("Money", "Money spending").apply { id = 1 }
            )
            private val resourceCounters =
                resources.map { _ -> ResourceCounter(1, 0, 15) }

            private val habitResources =
                habits.map {  habit -> HabitResource(habit.id, 1) }

            override fun getHabits(): List<Habit> = habits

            override fun getResourceById(resourceId: Long): Resource? = resources.find { it.id == resourceId }

            override fun getResourceCounterByResourceId(resourceId: Long): ResourceCounter? =
                resourceCounters.find { it.resourceId == resourceId }


            override fun getHabitResourceByHabitId(habitId: Long)  =
                habitResources.filter { it.habitId==habitId }
        }
    }
}
package com.example.neofr.habitcounter.dao

import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.model.ResourceAndCounter

class HabitCounterRepositoryImpl(private val habitDataSource: HabitDataSource) : HabitCounterRepository {
    override fun getHabitCounters(getCountersCallBack: GetCountersCallBack) {
        val habits = habitDataSource.getHabits();

        try {
            val habitCounters = habits.map { habit ->
                HabitCounter(
                    habit,
                    habitDataSource.getHabitResourceByHabitId(habit.id)
                        .map {
                            ResourceAndCounter(
                                habitDataSource.getResourceById(it.resourceId)!!,
                                habitDataSource.getResourceCounterByResourceId(it.resourceId)!!
                            )
                        }
                )
            }
            getCountersCallBack.onCountersLoaded(habitCounters)
        } catch (e: NullPointerException) {
            getCountersCallBack.onError()
        }
    }

    override fun updateHabitCounter(habitCounter: HabitCounter, updateHabitCallBack: UpdateHabitCallBack) {
        habitDataSource.updateHabit(habitCounter.habit)
        habitCounter.resourceCounters.forEach {
            habitDataSource.updateResource(it.resource)
            habitDataSource.updateResourceCounter(it.resourceCounter)
        }

        updateHabitCallBack.onAddHabit(habitCounter)
    }
}

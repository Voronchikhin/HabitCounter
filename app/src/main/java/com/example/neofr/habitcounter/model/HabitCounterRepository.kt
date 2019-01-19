package com.example.neofr.habitcounter.model


interface HabitCounterRepository {
    fun getHabitCounters(getCountersCallBack: GetCountersCallBack)
    fun addHabitCounter(habitCounter: HabitCounter, addHabitCallBack: AddHabitCallBack) // could update exists habit
    fun findHabitCounter(habitName: String, findHabitCallBack: FindHabitCallBack)
}

interface GetCountersCallBack {
    fun onCountersLoaded(counters: Collection<HabitCounter>)
    fun onError()
}

interface FindHabitCallBack {
    fun onFindHabitCallBack(counter: HabitCounter)
    fun onError()
}

interface AddHabitCallBack {
    fun onAddHabit(addedCounter: HabitCounter)
}
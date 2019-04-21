package com.example.neofr.habitcounter.dao

import android.arch.persistence.room.Dao
import com.example.neofr.habitcounter.model.HabitCounter

@Dao
class LocalDbDataSource : HabitDataSource {



    override fun getHabitCounters(getCountersCallBack: GetCountersCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addHabitCounter(habitCounter: HabitCounter, addHabitCallBack: AddHabitCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findHabitCounter(habitName: String, findHabitCallBack: FindHabitCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
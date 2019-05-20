package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.dao.HabitCounterRepositoryImpl
import com.example.neofr.habitcounter.dao.HabitDataSource
import com.example.neofr.habitcounter.dao.LocalDbHabitDataSourceImpl
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.model.dto.Habit
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.Presenter
import com.example.neofr.habitcounter.presenter.common.UseCaseHandler
import com.example.neofr.habitcounter.presenter.common.View
import com.example.neofr.habitcounter.view.IHabitView
import kotlin.random.Random

class HabitPresenter(
    private val view: View<HabitPresenter>,
    private val useCaseHandler: UseCaseHandler,
    private val localDbHabitDataSourceImpl: LocalDbHabitDataSourceImpl
) : Presenter {
    private fun loadHabits(){
        useCaseHandler.execute(loadUseCase, HabitRequest(), object : CallBack<HabitResponse> {
            override fun onSuccess(response: HabitResponse) {
                val habits = response.list
                (view as IHabitView).showHabits(habits)
            }
            override fun onError() {
                println("huy")
            }
        })
    }

    private val loadUseCase = LoadHabitCounters(HabitCounterRepositoryImpl(localDbHabitDataSourceImpl))
    private val countUseCase = DoCountUseCase(HabitCounterRepositoryImpl(localDbHabitDataSourceImpl))



    override fun start() {
        view.presenter = this
        loadHabits()
    }

    fun doCount(habitCounter: HabitCounter) {
        useCaseHandler.execute(countUseCase, DoCountRequest(habitCounter), object : CallBack<DoCountResponse> {
            override fun onError() {
                (view as IHabitView).showError()
            }

            override fun onSuccess(response: DoCountResponse) {
                (view as IHabitView).updateHabit(response.habitCounter)
            }
        })
    }
}
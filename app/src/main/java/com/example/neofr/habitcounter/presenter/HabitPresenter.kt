package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.dao.HabitCounterRepositoryImpl
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.Presenter
import com.example.neofr.habitcounter.presenter.common.UseCaseHandler
import com.example.neofr.habitcounter.presenter.common.View
import com.example.neofr.habitcounter.view.IHabitView

class HabitPresenter(private val view: View<HabitPresenter>, private val useCaseHandler: UseCaseHandler) : Presenter {
    private fun loadHabits(){
        useCaseHandler.execute(loadUseCase, HabitRequest(), object : CallBack<HabitResponse> {
            override fun onSuccess(response: HabitResponse) {
                val habits = response.list
                (view as IHabitView).showHabits(habits)
            }
            override fun onError() {

            }
        })
    }

    private val loadUseCase = LoadHabitCounters(HabitCounterRepositoryImpl.instance)
    private val countUseCase = DoCountUseCase()



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
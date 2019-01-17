package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.presenter.common.*

class HabitPresenter(val view: View<HabitPresenter>, private val useCaseHandler: UseCaseHandler): Presenter {
    private fun loadHabits(){
        useCaseHandler.execute(useCase, HabitRequest(), object : CallBack<HabitResponse>{
            override fun onSuccess(response: HabitResponse) {
                val habits = response.list
                println("get habits")
            }

            override fun onError() {

            }
        })
    }
    private val useCase = LoadHabitCounters()
    override fun start() {
        view.setPresenter(this)
        loadHabits()
    }
}
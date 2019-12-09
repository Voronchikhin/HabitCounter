package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.dao.HabitCounterRepository
import com.example.neofr.habitcounter.dao.UpdateHabitCallBack
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase

class DoCountUseCase(private val habitCounterRepository: HabitCounterRepository) : UseCase<DoCountResponse, DoCountRequest>() {
    override lateinit var callBack: CallBack<DoCountResponse>
    override lateinit var requestValue: DoCountRequest

    override fun execute(x: DoCountRequest) {
        val habitCounter = x.habitCounter
        habitCounter.doCount()
        habitCounterRepository.updateHabitCounter(habitCounter,object: UpdateHabitCallBack {
            override fun onAddHabit(addedCounter: HabitCounter) {
                callBack.onSuccess(DoCountResponse(addedCounter))
            }
        })
    }
}

class DoCountResponse(val habitCounter: HabitCounter) : UseCase.ResponseValue

data class DoCountRequest(val habitCounter: HabitCounter) : UseCase.RequestValue
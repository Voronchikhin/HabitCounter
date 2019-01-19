package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase

class DoCountUseCase() : UseCase<DoCountResponse, DoCountRequest>() {
    override lateinit var callBack: CallBack<DoCountResponse>
    override lateinit var requestValue: DoCountRequest

    override fun execute(x: DoCountRequest) {
        val habitCounter = x.habitCounter
        habitCounter.doCount()
        callBack.onSuccess(DoCountResponse(habitCounter))
    }
}

class DoCountResponse(val habitCounter: HabitCounter) : UseCase.ResponseValue

data class DoCountRequest(val habitCounter: HabitCounter) : UseCase.RequestValue
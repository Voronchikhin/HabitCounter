package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.model.HabitCounterRepositoryImpl
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase

class LoadHabitCounters() : UseCase<HabitResponse, HabitRequest >() {
    override lateinit var requestValue: HabitRequest
    override lateinit var callBack: CallBack<HabitResponse>

    override fun execute(x: HabitRequest){
        HabitResponse(HabitCounterRepositoryImpl.instance.getHabitCounters().toList())
    }
}

data class HabitResponse(val list: List<HabitCounter>) : UseCase.ResponseValue

class HabitRequest() : UseCase.RequestValue
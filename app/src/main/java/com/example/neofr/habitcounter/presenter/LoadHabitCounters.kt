package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase
import java.util.Arrays.asList

class LoadHabitCounters() : UseCase<HabitResponse, HabitRequest >() {
    override lateinit var requestValue: HabitRequest
    override lateinit var callBack: CallBack<HabitResponse>

    override fun execute(x: HabitRequest){
        HabitResponse(asList( HabitCounterFactory().createHabit(1)))
    }
}

data class HabitResponse(val list: List<HabitCounter>) : UseCase.ResponseValue

class HabitRequest() : UseCase.RequestValue
package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.model.GetCountersCallBack
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.model.HabitCounterRepository
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase

class LoadHabitCounters(private val habitCounterRepository: HabitCounterRepository) :
    UseCase<HabitResponse, HabitRequest>() {
    override lateinit var requestValue: HabitRequest
    override lateinit var callBack: CallBack<HabitResponse>

    override fun execute(x: HabitRequest){
        habitCounterRepository.getHabitCounters(object : GetCountersCallBack {
            override fun onCountersLoaded(counters: Collection<HabitCounter>) {
                callBack.onSuccess(HabitResponse(counters.toList()))
            }

            override fun onError() {
                callBack.onError()
            }
        })
    }
}

data class HabitResponse(val list: List<HabitCounter>) : UseCase.ResponseValue

class HabitRequest() : UseCase.RequestValue
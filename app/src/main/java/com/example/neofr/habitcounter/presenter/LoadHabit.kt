package com.example.neofr.habitcounter.presenter

import com.example.neofr.habitcounter.model.Habit
import com.example.neofr.habitcounter.presenter.common.CallBack
import com.example.neofr.habitcounter.presenter.common.UseCase
import java.util.Arrays.asList

class LoadHabit() : UseCase<HabitResponse, HabitRequest >() {
    override lateinit var requestValue: HabitRequest
    override lateinit var callBack: CallBack<HabitResponse>

    override fun execute(x: HabitRequest){
        HabitResponse(asList( Habit("Smoking","Huy")))
    }
}

data class HabitResponse(val list: List<Habit>) : UseCase.ResponseValue

class HabitRequest() : UseCase.RequestValue
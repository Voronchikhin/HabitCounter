package com.example.neofr.habitcounter.presenter.common

interface UseCaseScheduler {
    fun execute(runnable: Runnable)

    fun <T : UseCase.ResponseValue> onResponse(response :  T, callBack : CallBack<T> )
    fun <T : UseCase.ResponseValue> onError(callBack: CallBack<T>)
}
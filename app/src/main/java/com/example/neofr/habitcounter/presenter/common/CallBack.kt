package com.example.neofr.habitcounter.presenter.common

interface CallBack<Response : UseCase.ResponseValue> {
    fun onSuccess(response: Response)
    fun onError()
}
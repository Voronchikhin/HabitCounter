package com.example.neofr.habitcounter.presenter.common

abstract class UseCase<ResponseType : UseCase.ResponseValue, RequestType : UseCase.RequestValue> {
    interface ResponseValue
    interface RequestValue

    abstract var callBack: CallBack<ResponseType>
    abstract var requestValue: RequestType
    fun run() = execute(requestValue)
    protected abstract fun execute(x: RequestType)
}
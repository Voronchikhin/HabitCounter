package com.example.neofr.habitcounter.presenter.common

class UseCaseCallBackCallWrapper<ResponseType : UseCase.ResponseValue>
    (val callBack: CallBack<ResponseType>, val handler: UseCaseHandler) : CallBack<ResponseType> {
    override fun onSuccess(response: ResponseType) {
        handler.notifyOnSuccess(response,callBack)
    }

    override fun onError() {
        handler.notifyOnError(callBack)
    }
}
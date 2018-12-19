package com.example.neofr.habitcounter.presenter.common

class UseCaseHandler {
    //TODO : make singleton
    private val scheduler = UseCaseSchedulerImpl()

    fun <ResponseType : UseCase.ResponseValue, RequestType : UseCase.RequestValue> execute(
        useCase: UseCase<ResponseType, RequestType>,
        request: RequestType,
        callBack: CallBack<ResponseType>
    ) {
        useCase.requestValue = request
        useCase.callBack = UseCaseCallBackCallWrapper(callBack, this)
        scheduler.threadPoolExecutor.submit { -> useCase.run() }
    }

    fun <ResponseType : UseCase.ResponseValue> notifyOnSuccess(
        response: ResponseType,
        callBack: CallBack<ResponseType>
    ) {
        scheduler.onResponse(response, callBack)
    }

    fun <ResponseType : UseCase.ResponseValue> notifyOnError(callBack: CallBack<ResponseType>) {
        scheduler.onError(callBack)
    }
}

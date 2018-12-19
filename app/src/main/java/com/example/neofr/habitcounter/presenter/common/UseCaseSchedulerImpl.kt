package com.example.neofr.habitcounter.presenter.common

import android.os.Handler
import java.time.chrono.ThaiBuddhistChronology
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

class UseCaseSchedulerImpl : UseCaseScheduler {
    private val POOLSIZE = 4;
    private val handler = Handler()
    val threadPoolExecutor = Executors.newFixedThreadPool(POOLSIZE)
    override fun execute(runnable: Runnable) {
        threadPoolExecutor.submit(runnable)
    }

    override fun <T : UseCase.ResponseValue> onResponse(response: T, callBack: CallBack<T>) {
        handler.post{callBack.onSuccess(response)}
    }

    override fun <T : UseCase.ResponseValue> onError(callBack: CallBack<T>) {
        handler.post{callBack.onError()}
    }
}
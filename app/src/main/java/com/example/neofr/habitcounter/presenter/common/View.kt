package com.example.neofr.habitcounter.presenter.common

interface View<T:Presenter> {
    fun setPresenter (presenter: T)
}
package com.example.neofr.habitcounter.presenter.common

interface View<T:Presenter> {
    var presenter: Presenter
}
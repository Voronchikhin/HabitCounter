package com.example.neofr.habitcounter.model

abstract class Measure <T : Number>(val value: T) {
    abstract operator fun plus(measure: Measure<T>):Measure<T>
    abstract operator fun minus(measure: Measure<T>):Measure<T>
}

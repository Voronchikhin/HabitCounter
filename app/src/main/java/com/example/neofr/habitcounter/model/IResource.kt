package com.example.neofr.habitcounter.model

import java.util.*

interface IResource {
    fun getName():String
    fun getMeasures():Collection<Objects>
    fun bindMeasure()
}

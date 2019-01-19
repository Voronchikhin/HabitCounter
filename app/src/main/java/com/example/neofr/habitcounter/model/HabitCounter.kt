package com.example.neofr.habitcounter.model

import java.util.*

class HabitCounter(val habit: Habit) {
    fun doCount() {
        resourceCounters.forEach { it.doCount() }
    }

    //хранит сколько ресурсов привычка тратит за 1 раз
    val resourceCounters = LinkedHashSet<ResourceCounter>()

    // TODO: заменить на нормальное хранение лога( прикрутить БД)
    //хранит историю прибегания к привычке
    private val habitLog = LinkedList<Date>()

    fun addResource(resource: Resource, measure: Int) {
        resourceCounters.add(ResourceCounter(resource, measure))

        habitLog.push(Date())
    }

}


// TODO: var count не помешало бы хранить в БД
class ResourceCounter(val resource: Resource, val measure: Int) {
    var count = resource.count
        private set

    fun doCount() {
        count += measure
    }
}
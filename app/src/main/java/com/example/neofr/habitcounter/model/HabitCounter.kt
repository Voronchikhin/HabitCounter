package com.example.neofr.habitcounter.model

import java.util.*

class HabitCounter(val habit: Habit) {
    fun doCount() {
        resourceCounters.forEach { it.doCount() }
    }

    //хранит сколько ресурсов привычка тратит за 1 раз
    private val resourceCounters = LinkedHashSet<ResourceCounter>()

    // TODO: заменить на нормальное хранение лога( прикрутить БД)
    //хранит историю прибегания к привычке
    private val habitLog = LinkedList<Date>()

    fun addResource(resource: Resource, measure: Int, initCount: Int) {
        resourceCounters.add(ResourceCounter(resource, measure, initCount))

        habitLog.push(Date())
    }

}


// TODO: var count не помешало бы хранить в БД
class ResourceCounter(resource: Resource, val measure: Int, count: Int) {
    var count = count
        private set

    fun doCount() {
        count += measure;
    }
}
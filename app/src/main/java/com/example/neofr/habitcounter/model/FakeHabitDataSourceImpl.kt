package com.example.neofr.habitcounter.model

class FakeHabitDataSourceImpl : HabitDataSource {
    override fun getHabitCounters(getCountersCallBack: GetCountersCallBack) {
        getCountersCallBack.onCountersLoaded(habits.values)
    }

    override fun addHabitCounter(habitCounter: HabitCounter, addHabitCallBack: AddHabitCallBack) {
        addHabitCounter(habitCounter)
        addHabitCallBack.onAddHabit(habitCounter)

    }

    override fun findHabitCounter(habitName: String, findHabitCallBack: FindHabitCallBack) {
        val habit = habits[habitName]
        if (habit != null) {
            findHabitCallBack.onFindHabitCallBack(habit)
            return
        }
        findHabitCallBack.onError()
    }

    private val habits = HashMap<String, HabitCounter>()

    init {

        val smokingHabit = Habit("Smoking", "smoke siggarettes")
        val drinkHabit = Habit("Drink Alcohol", "drinking vodka, beer and so on")
        val timeResource = Resource("Time", 0)
        val moneyResource = Resource("Money", 0)



        val drinkHabitCounter = HabitCounter(smokingHabit)
        val smokeHabitCounter = HabitCounter(drinkHabit)

        drinkHabitCounter.addResource(timeResource, 5 * 60)
        drinkHabitCounter.addResource(moneyResource, 500)

        smokeHabitCounter.addResource(timeResource, 60 * 60)
        smokeHabitCounter.addResource(moneyResource, 150)

        addHabitCounter(drinkHabitCounter)
        addHabitCounter(smokeHabitCounter)
    }

    private fun addHabitCounter(habitCounter: HabitCounter) {
        habits[habitCounter.habit.name] = habitCounter

        val thread = Thread(
            Runnable {
                val habit = habitCounter.habit

                val db = App.getInstance().database
                val habitDao = db.habitDao()
                habitDao.insert(habit)


                val habits = habitDao.all
                println("*********************************************************************")
                println(habits.joinToString { "${it.id}  ${it.name}  ${it.description}" })
            })
        thread.start()
        thread.join()
    }

}
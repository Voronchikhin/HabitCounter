package com.example.neofr.habitcounter.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.neofr.habitcounter.R
import com.example.neofr.habitcounter.model.HabitCounter
import com.example.neofr.habitcounter.presenter.HabitPresenter
import com.example.neofr.habitcounter.presenter.common.Presenter


class FeedFragment : Fragment(), IHabitView {
    override fun updateHabit(habitCounter: HabitCounter) {
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showHabits(habits: Collection<HabitCounter>) {
        adapter = HabitAdapter(habits.toList())
        recyclerView.adapter = adapter
    }


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HabitAdapter

    override lateinit var presenter: Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        recyclerView = view.findViewById(R.id.feed_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    inner class HabitHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.feed_item, parent, false)) {
        var habitName: TextView = itemView.findViewById(R.id.feed_habit_name)
        var habitCount: TextView = itemView.findViewById(R.id.feed_habit_count)
        val countButton: Button = itemView.findViewById(R.id.doCountButton)

        lateinit var counter: HabitCounter
        fun bind(habitCounter: HabitCounter) {
            this.counter = habitCounter
            habitName.text = this.counter.habit.name
            this.habitCount.text = this.counter
                .resourceCounters
                .joinToString(
                    separator = "\n",
                    transform = { "${it.resource.name}: ${it.count}\n" }
                )
            val image: ImageView = itemView.findViewById(R.id.feed_habit_view)
            image.setImageResource(R.drawable.smoke_logo)
            countButton.setOnClickListener {
                (presenter as HabitPresenter).doCount(habitCounter)
            }
        }

    }

    inner class HabitAdapter(var habits: List<HabitCounter>) : RecyclerView.Adapter<HabitHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HabitHolder {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            return HabitHolder(inflater, parent)
        }

        override fun getItemCount(): Int = habits.size

        override fun onBindViewHolder(habitHolder: HabitHolder, idx: Int) {
            val habitCounter = habits.get(idx)
            habitHolder.bind(habitCounter)
        }
    }
}
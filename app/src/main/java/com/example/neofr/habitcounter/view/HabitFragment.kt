package com.example.neofr.habitcounter.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.neofr.habitcounter.R


class HabitFragment : Fragment() {
    lateinit var habitName:TextView
    lateinit var habitImage: ImageView
    lateinit var habitCount: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_habit,container,false)
        configureView(view)
        return view
    }
    private fun configureView(view: View){
        habitName=view.findViewById(R.id.habitName)
        habitImage=view.findViewById(R.id.habitImage)
        habitCount=view.findViewById(R.id.habitCount)
    }
}

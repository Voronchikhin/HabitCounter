package com.example.neofr.habitcounter.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Habit {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String description;

    public Habit() {
    }

    public Habit(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
}
package com.example.neofr.habitcounter.model;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {
    public static App instance;

    private KotlinLicksAss database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, KotlinLicksAss.class, "database").build();
    }

    public static App getInstance() {
        return instance;
    }

    public KotlinLicksAss getDatabase() {
        return database;
    }
}

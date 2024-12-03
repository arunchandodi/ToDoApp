package com.example.mytodoapp

import android.app.Application
import androidx.room.Room
import com.example.mytodoapp.model.ToDoDatabase

class ToDoApp: Application(){

    companion object {
        lateinit var todoDB: ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDB = Room.databaseBuilder(
            applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME
        ).build()
    }
}
package com.example.mytodoapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytodoapp.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    companion object {
        const val NAME = "ToDo_DB"
    }

    abstract fun getToDoDao(): ToDoDao
}
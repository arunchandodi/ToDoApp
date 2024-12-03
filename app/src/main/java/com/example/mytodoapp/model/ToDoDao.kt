package com.example.mytodoapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mytodoapp.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM TODO")
    fun getAllToDo(): LiveData<List<ToDo>>

    @Insert
    fun addToDo(todo: ToDo)

    @Query("DELETE FROM TODO WHERE id = :id")
    fun deleteToDo(id: Int)
}
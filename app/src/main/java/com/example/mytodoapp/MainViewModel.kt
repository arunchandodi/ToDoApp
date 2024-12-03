package com.example.mytodoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val toDoDao = ToDoApp.todoDB.getToDoDao()

    val toDoList: LiveData<List<ToDo>> = toDoDao.getAllToDo()

    fun addTodo(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.addToDo(ToDo(text = title))
        }
    }
}
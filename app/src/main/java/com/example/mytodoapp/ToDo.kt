package com.example.mytodoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var text: String
)

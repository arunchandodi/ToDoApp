package com.example.mytodoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val todoList by viewModel.toDoList.observeAsState()

    if (todoList == null) {
                Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Please click + to Add",
                    fontSize = 18.sp
                )
            }
        }

    } else {
        todoList?.let {
            LazyColumn {
                itemsIndexed(it) { index: Int, item: ToDo ->
                    ToDoItem(item.text)
                }
            }
        }
    }
}

@Composable
fun ToDoItem(item: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Column {
            Text(
                text = item,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal
            )
        }
    }
}


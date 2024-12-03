package com.example.mytodoapp

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navCtl: NavController, viewModel: MainViewModel) {
    var inputText by remember {
        mutableStateOf("")
    }
    val ctx = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth().padding(
        horizontal = 40.dp
    )) {
        OutlinedTextField(inputText, onValueChange = {
            inputText = it
        })
        Button(onClick = {
            if(inputText == "Error"){
                Toast.makeText(ctx, "Failed to add ToDo", Toast.LENGTH_LONG).show()
                navCtl.navigate(NavigationRoutes.MAIN_SCREEN)
            }
            else {
                viewModel.addTodo(inputText)
                navCtl.navigate(NavigationRoutes.MAIN_SCREEN)
            }
        }) {
            Text(text = "Add TODO")
        }
    }
}


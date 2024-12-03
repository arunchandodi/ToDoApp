package com.example.mytodoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mytodoapp.ui.theme.MyToDoAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val todoViewModel = ViewModelProvider(this)[MainViewModel::class.java]
            val navCtl = rememberNavController()
            MyToDoAppTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 30.dp),
                    floatingActionButton = {
                        FunctionFloatingActionButton(navCtl)
                    }) {
                    NavigationScreen(navCtl, todoViewModel)
                }
            }
        }
    }
}

@Composable
fun FunctionFloatingActionButton(navCtl: NavController){
    Column(horizontalAlignment = Alignment.End){
        FloatingActionButton(
            onClick = {navCtl.navigate(NavigationRoutes.DETAILS_SCREEN)},
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}


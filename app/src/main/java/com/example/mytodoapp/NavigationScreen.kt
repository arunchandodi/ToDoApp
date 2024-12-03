package com.example.mytodoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationScreen(navCtl: NavHostController, viewModel: MainViewModel) {

    NavHost(navController = navCtl, startDestination = NavigationRoutes.MAIN_SCREEN) {
        composable(route = NavigationRoutes.MAIN_SCREEN) {
            MainScreen(viewModel)
        }
        composable(route = NavigationRoutes.DETAILS_SCREEN) {
            DetailsScreen(navCtl, viewModel)
        }
    }
}

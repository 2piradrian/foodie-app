package com.twopiradrian.foodie.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.twopiradrian.foodie.screen.register.ui.RegisterScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    
    NavHost(
            navController = navController,
            startDestination = AppScreens.RegisterScreen.route
    ){
        composable(AppScreens.RegisterScreen.route){
            RegisterScreen(
                    navController = navController
            )
        }
    }
}
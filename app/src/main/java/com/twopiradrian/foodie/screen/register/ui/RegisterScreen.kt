@file:OptIn(ExperimentalMaterial3Api::class)

package com.twopiradrian.foodie.screen.register.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.twopiradrian.foodie.screen.register.RegisterViewModel
import com.twopiradrian.foodie.screen.register.ui.structure.Body

@Composable
fun RegisterScreen(
        navController: NavController,
        viewModel: RegisterViewModel = viewModel(),
) {
    
    val emailInput = viewModel.emailInput.collectAsState()
    val passwordInput = viewModel.passwordInput.collectAsState()
    
    Scaffold(modifier = Modifier.fillMaxSize(),
            content = { paddingValues ->
                Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                ) {
                    Body(
                            viewModel = viewModel,
                            emailInput = emailInput,
                            passwordInput = passwordInput,
                    )
                }
            },
            bottomBar = {
                Text(text = "Log in")
            })
}
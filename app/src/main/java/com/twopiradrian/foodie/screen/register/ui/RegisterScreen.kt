@file:OptIn(ExperimentalMaterial3Api::class)

package com.twopiradrian.foodie.screen.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.twopiradrian.foodie.screen.register.RegisterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.twopiradrian.foodie.screen.register.ui.structure.Body

@Composable
fun RegisterScreen(
        navController: NavController,
        viewModel: RegisterViewModel = viewModel(),
) {
    
    val emailInput = viewModel.emailInput.collectAsState()
    
    Scaffold (
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Body(
                            viewModel = viewModel,
                            emailInput = emailInput
                    )
                }
            },
            bottomBar = {
                Text(text = "Log in")
            }
    )
}
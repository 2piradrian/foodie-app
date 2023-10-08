package com.twopiradrian.foodie.screen.register.ui.structure

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.twopiradrian.foodie.R
import com.twopiradrian.foodie.core.data.InputStructure
import com.twopiradrian.foodie.core.data.InputType
import com.twopiradrian.foodie.screen.register.RegisterViewModel
import com.twopiradrian.foodie.ui.components.input.StyledInput

@Composable
fun Body(
        viewModel: RegisterViewModel,
        emailInput: State<InputStructure>,
) {
    val focusManager = LocalFocusManager.current
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.donnut_animation))
    
    Column(
            modifier = Modifier.fillMaxSize()
    ) {
        LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.weight(0.3f)
        )
        Column(
                modifier = Modifier.fillMaxSize().weight(0.7f)
        ) {
            StyledInput(
                    state = emailInput.value,
                    onValueChange = {
                        viewModel.onRegisterChange(
                                it,
                                //passwordInput.value.value,
                                //repeatPasswordInput.value.value
                        )
                    },
                    focusManager = focusManager,
                    label = R.string.email_label,
                    placeholder = R.string.email_placeholder,
                    inputType = InputType.EMAIL
            )
        }
    }
}
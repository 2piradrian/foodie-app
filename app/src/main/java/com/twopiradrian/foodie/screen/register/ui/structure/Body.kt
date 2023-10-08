package com.twopiradrian.foodie.screen.register.ui.structure

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.twopiradrian.foodie.R
import com.twopiradrian.foodie.core.data.InputStructure
import com.twopiradrian.foodie.core.data.InputType
import com.twopiradrian.foodie.screen.register.RegisterViewModel
import com.twopiradrian.foodie.ui.components.button.MainButton
import com.twopiradrian.foodie.ui.components.input.StyledInput

@Composable
fun Body(
        viewModel: RegisterViewModel,
        emailInput: State<InputStructure>,
        passwordInput: State<InputStructure>,
) {
    val focusManager = LocalFocusManager.current
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.donnut_animation))
    
    Column(
            modifier = Modifier
                .widthIn(max = 500.dp)
                .fillMaxSize()
                .padding(16.dp)
    ) {
        LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.weight(0.4f)
        )
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f)
        ) {
            StyledInput(
                    state = emailInput.value,
                    onValueChange = {
                        viewModel.onRegisterChange(
                                it,
                                passwordInput.value.value,
                                //repeatPasswordInput.value.value
                        )
                    },
                    focusManager = focusManager,
                    label = R.string.email_label,
                    placeholder = R.string.email_placeholder,
                    inputType = InputType.EMAIL
            )
            StyledInput(
                    state = passwordInput.value,
                    onValueChange = {
                        viewModel.onRegisterChange(
                                emailInput.value.value,
                                it,
                                //repeatPasswordInput.value.value
                        )
                    },
                    focusManager = focusManager,
                    label = R.string.password_label,
                    placeholder = R.string.password_placeholder,
                    inputType = InputType.PASSWORD
            )
            MainButton(
                    isEnabled = viewModel.isButtonEnabled(),
                    text = stringResource(id = R.string.register_button),
                    onClick = { /*TODO*/ })
        }
    }
}
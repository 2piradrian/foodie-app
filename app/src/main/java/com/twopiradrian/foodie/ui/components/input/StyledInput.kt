@file:OptIn(ExperimentalMaterial3Api::class)

package com.twopiradrian.foodie.ui.components.input

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.twopiradrian.foodie.core.data.InputStructure
import com.twopiradrian.foodie.core.data.InputType


@Composable
fun StyledInput(
        state: InputStructure,
        inputType: InputType,
        @StringRes label: Int,
        @StringRes placeholder: Int,
        onValueChange: (String) -> Unit,
        focusManager: FocusManager,
        singleLine: Boolean = true,
) {
    val keyboardOptions = KeyboardOptions(
            keyboardType = when (inputType) {
                InputType.EMAIL -> KeyboardType.Email
                InputType.PASSWORD -> KeyboardType.Password
                InputType.TEXT -> KeyboardType.Text
            }
    )
    
    val visualTransformation = when (inputType) {
        InputType.PASSWORD -> PasswordVisualTransformation()
        else -> VisualTransformation.None
    }
    
    Column {
        Text(
                text = stringResource(label),
                modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
                value = state.value,
                onValueChange = onValueChange,
                //
                maxLines = 1,
                singleLine = singleLine,
                keyboardOptions = keyboardOptions,
                visualTransformation = visualTransformation,
                keyboardActions = KeyboardActions(onDone = { focusManager.moveFocus(FocusDirection.Down) }),
                //
                placeholder = { Text(text = stringResource(placeholder)) },
                colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
        )
        AnimatedVisibility(visible = state.isError) {
            Text(
                    text = if (state.isError) stringResource(state.errorText) else "",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
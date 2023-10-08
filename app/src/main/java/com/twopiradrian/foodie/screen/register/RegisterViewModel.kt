package com.twopiradrian.foodie.screen.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.twopiradrian.foodie.R
import com.twopiradrian.foodie.core.data.InputStructure
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel(), RegisterActions {
    
    private val _emailInput = MutableStateFlow(InputStructure.empty())
    val emailInput: StateFlow<InputStructure> = _emailInput
    
    private val _passwordInput = MutableStateFlow(InputStructure.empty())
    val passwordInput: StateFlow<InputStructure> = _passwordInput
    
    
    override fun onRegisterChange(
            email: String,
            password: String
    ) {
        _emailInput.update {
            it.copy(
                    value = email,
                    isError = !isEmailValid(email)
            )
        }
        _passwordInput.update {
            it.copy(
                    value = password,
                    isError = !isPasswordValid(password)
            )
        }
    }
    
    override fun isButtonEnabled(): Boolean {
        return !emailInput.value.isError && !passwordInput.value.isError
    }
    
    // Utils ----- >
    
    private fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) {
            _emailInput.value = _emailInput.value.copy(
                    errorText = R.string.email_required
            )
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailInput.value = _emailInput.value.copy(
                    errorText = R.string.email_invalid
            )
            return false
        }
        _emailInput.value = _emailInput.value.copy(
                errorText = R.string.no_error
        )
        return true
    }
    
    private fun isPasswordValid(password: String): Boolean {
        if (password.isEmpty()) {
            _passwordInput.value = _passwordInput.value.copy(
                    errorText = R.string.password_required
            )
            return false
        } else if (password.length < 8) {
            _passwordInput.value = _passwordInput.value.copy(
                    errorText = R.string.password_too_short
            )
            return false
        }
        _passwordInput.value = _passwordInput.value.copy(
                errorText = R.string.no_error
        )
        return true
    }
    
}
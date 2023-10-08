package com.twopiradrian.foodie.screen.register

import android.util.Log
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
    
    override fun onRegisterChange(email: String) {
        _emailInput.update {
            it.copy(
                    value = email,
                    isError = !isEmailValid(email)
            )
        }
    }
    
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
    
}
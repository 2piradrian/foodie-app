package com.twopiradrian.foodie.screen.register

interface RegisterActions {
    fun onRegisterChange(
            email: String,
            password: String,
            //repeatPassword: String
    )
    fun isButtonEnabled(): Boolean
}
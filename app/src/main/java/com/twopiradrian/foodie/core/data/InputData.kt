package com.twopiradrian.foodie.core.data

import androidx.annotation.StringRes

data class InputStructure(
        val value: String,
        val isError: Boolean,
        @StringRes val errorText: Int,
) {
    companion object {
        fun empty() = InputStructure("", false, 0)
    }
}

enum class InputType {
    EMAIL,
    PASSWORD,
    TEXT,
}


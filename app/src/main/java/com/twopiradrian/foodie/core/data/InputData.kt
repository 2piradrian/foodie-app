package com.twopiradrian.foodie.core.data

import androidx.annotation.StringRes
import com.twopiradrian.foodie.R

data class InputStructure(
        val value: String,
        val isError: Boolean,
        @StringRes val errorText: Int,
) {
    companion object {
        fun empty() = InputStructure("", false, R.string.no_error)
    }
}

enum class InputType {
    EMAIL,
    PASSWORD,
    TEXT,
}


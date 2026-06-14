package com.nathan.afritextexchange.utils

import android.util.Patterns

object ValidationUtils {
    fun isNotEmpty(text: String): Boolean = text.isNotBlank()

    fun isValidEmail(email: String): Boolean =
        email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidPassword(password: String): Boolean =
        password.length >= 6

    fun isValidPrice(price: String): Boolean {
        val value = price.toDoubleOrNull()
        return value != null && value > 0
    }
}
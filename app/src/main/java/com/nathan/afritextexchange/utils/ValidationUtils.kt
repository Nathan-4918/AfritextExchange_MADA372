package com.nathan.afritextexchange.utils

object ValidationUtils {

    fun isNotEmpty(value: String): Boolean = value.isNotBlank()

    fun isValidEmail(email: String): Boolean =
        email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isValidPassword(password: String): Boolean = password.length >= 6

    fun isValidPrice(price: String): Boolean {
        if (price.isBlank()) return false
        return price.toDoubleOrNull()?.let { it > 0 } ?: false
    }
}
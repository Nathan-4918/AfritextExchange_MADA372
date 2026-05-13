package com.nathan.afritextexchange.models

import android.accessibilityservice.GestureDescription

data class Book (
    val id: Int,
    val title: String,
    val author: String,
    val price : Double,
    val subject: String,
    val condition: String,
    val description: String,
    val sellerName: String
)



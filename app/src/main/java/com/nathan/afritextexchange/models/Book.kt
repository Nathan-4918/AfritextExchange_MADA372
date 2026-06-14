package com.nathan.afritextexchange.models

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val price: Double,
    val subject: String,
    val condition: String,
    val description: String,
    val sellerName: String,
    val edition: String = "",
    val imageRes: Int = 0
)
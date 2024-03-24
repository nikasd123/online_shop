package com.tz.online_shop.domain.models

data class Product(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: Price,
    val feedback: Feedback,
    val description: String,
    val tags: List<String>,
    val available: Int,
    val info: List<Info>,
    val ingredients: String
)

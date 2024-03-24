package com.tz.online_shop.domain.models

data class Price(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
)

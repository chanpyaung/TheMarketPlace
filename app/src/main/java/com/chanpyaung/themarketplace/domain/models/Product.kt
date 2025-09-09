package com.chanpyaung.themarketplace.domain.models

data class Product(
    val id: Long = -1L,
    val title: String = "",
    val location: String = "",
    val currentPrice: String = "",
    val buyNowPrice: String = "",
    val hasBuyNow: Boolean = false,
    val isClassified: Boolean = false,
    val displayPrice: String = "",
    val imageUrl: String = "",
    val reserveState: String = "",
)
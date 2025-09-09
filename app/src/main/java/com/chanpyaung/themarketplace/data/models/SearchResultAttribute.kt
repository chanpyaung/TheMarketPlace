package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResultAttribute(
    @SerialName("DisplayValue")
    val displayValue: String = "",
    @SerialName("Id")
    val id: Int = 0,
    @SerialName("Name")
    val name: String = ""
)
package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PropertySaleInformation(
    @SerialName("PropertyDateOfSale")
    val propertyDateOfSale: String = "",
    @SerialName("PropertySaleType")
    val propertySaleType: Int = 0
)
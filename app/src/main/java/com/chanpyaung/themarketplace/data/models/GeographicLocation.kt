package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeographicLocation(
    @SerialName("Accuracy")
    val accuracy: Int = 0,
    @SerialName("Easting")
    val easting: Int = 0,
    @SerialName("Latitude")
    val latitude: Double = 0.0,
    @SerialName("Longitude")
    val longitude: Double = 0.0,
    @SerialName("Northing")
    val northing: Int = 0
)
package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdditionalData(
    @SerialName("BulletPoints")
    val bulletPoints: List<Any> = emptyList(),
    @SerialName("Tags")
    val tags: List<Any> = emptyList()
)
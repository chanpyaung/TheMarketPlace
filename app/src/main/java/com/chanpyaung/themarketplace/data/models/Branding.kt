package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Branding(
    @SerialName("LargeBannerURL")
    val largeBannerURL: String = "",
    @SerialName("LargeWideLogo")
    val largeWideLogo: String = ""
)
package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListingResponse(
    @SerialName("List")
    val list: List<ProductData> = emptyList(),
    @SerialName("Page")
    val page: Int = 0,
    @SerialName("PageSize")
    val pageSize: Int = 0,
    @SerialName("TotalCount")
    val totalCount: Int = 0
)
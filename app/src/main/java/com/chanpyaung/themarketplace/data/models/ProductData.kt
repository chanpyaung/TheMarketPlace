package com.chanpyaung.themarketplace.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductData(
    @SerialName("Address")
    val address: String = "",
    @SerialName("AdjacentSuburbIds")
    val adjacentSuburbIds: List<Int> = listOf(),
    @SerialName("AdjacentSuburbNames")
    val adjacentSuburbNames: List<String> = emptyList(),
    @SerialName("AgencyReference")
    val agencyReference: String = "",
    @SerialName("Area")
    val area: Int = 0,
    @SerialName("AsAt")
    val asAt: String = "",
    @SerialName("AvailableFrom")
    val availableFrom: String = "",
    @SerialName("Bathrooms")
    val bathrooms: Int = 0,
    @SerialName("Bedrooms")
    val bedrooms: Int = 0,
    @SerialName("Branding")
    val branding: Branding = Branding(),
    @SerialName("BuyNowPrice")
    val buyNowPrice: Double = 0.0,
    @SerialName("Category")
    val category: String = "",
    @SerialName("CategoryPath")
    val categoryPath: String = "",
    @SerialName("Company")
    val company: String = "",
    @SerialName("District")
    val district: String = "",
    @SerialName("DistrictId")
    val districtId: Int = 0,
    @SerialName("EndDate")
    val endDate: String = "",
    @SerialName("GeographicLocation")
    val geographicLocation: GeographicLocation = GeographicLocation(),
    @SerialName("HasBuyNow")
    val hasBuyNow: Boolean = false,
    @SerialName("HasEmbeddedVideo")
    val hasEmbeddedVideo: Boolean = false,
    @SerialName("HasGallery")
    val hasGallery: Boolean = false,
    @SerialName("HasSearchCardBranding")
    val hasSearchCardBranding: Boolean = false,
    @SerialName("IsBold")
    val isBold: Boolean = false,
    @SerialName("IsBuyNowOnly")
    val isBuyNowOnly: Boolean = false,
    @SerialName("IsClassified")
    val isClassified: Boolean = false,
    @SerialName("IsDealer")
    val isDealer: Boolean = false,
    @SerialName("IsFeatured")
    val isFeatured: Boolean = false,
    @SerialName("IsHighlighted")
    val isHighlighted: Boolean = false,
    @SerialName("IsNew")
    val isNew: Boolean = false,
    @SerialName("IsSuperFeatured")
    val isSuperFeatured: Boolean = false,
    @SerialName("LandArea")
    val landArea: Int = 0,
    @SerialName("ListingGroup")
    val listingGroup: String = "",
    @SerialName("ListingId")
    val listingId: Long = 0,
    @SerialName("Lounges")
    val lounges: Int = 0,
    @SerialName("MaxTenants")
    val maxTenants: Int = 0,
    @SerialName("MemberId")
    val memberId: Int = 0,
    @SerialName("NoteDate")
    val noteDate: String = "",
    @SerialName("Parking")
    val parking: String = "",
    @SerialName("PetsOkay")
    val petsOkay: Int = 0,
    @SerialName("PhotoUrls")
    val photoUrls: List<String> = listOf(),
    @SerialName("PictureHref")
    val pictureHref: String = "",
    @SerialName("PriceDisplay")
    val priceDisplay: String = "",
    @SerialName("PromotionId")
    val promotionId: Int = 0,
    @SerialName("PropertyId")
    val propertyId: String = "",
    @SerialName("PropertySaleInformation")
    val propertySaleInformation: PropertySaleInformation = PropertySaleInformation(),
    @SerialName("PropertyType")
    val propertyType: String = "",
    @SerialName("Region")
    val region: String = "",
    @SerialName("RegionId")
    val regionId: Int = 0,
    @SerialName("RentPerWeek")
    val rentPerWeek: Int = 0,
    @SerialName("ReserveState")
    val reserveState: Int = 0,
    @SerialName("SearchCardTier")
    val searchCardTier: Int = 0,
    @SerialName("SearchResultAttributes")
    val searchResultAttributes: List<SearchResultAttribute> = listOf(),
    @SerialName("SmokersOkay")
    val smokersOkay: Int = 0,
    @SerialName("StartDate")
    val startDate: String = "",
    @SerialName("StartPrice")
    val startPrice: Double = 0.0,
    @SerialName("Subtitle")
    val subtitle: String = "",
    @SerialName("Suburb")
    val suburb: String = "",
    @SerialName("SuburbId")
    val suburbId: Int = 0,
    @SerialName("Title")
    val title: String = "",
    @SerialName("TotalParking")
    val totalParking: Int = 0,
    @SerialName("__type")
    val type: String = "",
    @SerialName("ViewingInstructions")
    val viewingInstructions: String = "",
    @SerialName("Whiteware")
    val whiteware: String = ""
)
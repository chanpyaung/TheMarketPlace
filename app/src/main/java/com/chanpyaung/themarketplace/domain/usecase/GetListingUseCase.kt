package com.chanpyaung.themarketplace.domain.usecase

import com.chanpyaung.themarketplace.data.models.ReserveState
import com.chanpyaung.themarketplace.data.repository.DataRepository
import com.chanpyaung.themarketplace.domain.models.Product
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@ViewModelScoped
class GetListingUseCase @Inject constructor(
    private val repository: DataRepository,
) {
    suspend operator fun invoke(): Result<List<Product>> =
        coroutineScope {
            try {
                val productList = repository.getListing().list
                    .map {
                        val reserveState = ReserveState.fromInt(it.reserveState)
                        Product(
                            id = it.listingId,
                            title = it.title,
                            location = it.region,
                            hasBuyNow = it.hasBuyNow,
                            isClassified = it.isClassified,
                            imageUrl = it.photoUrls.firstOrNull().orEmpty(),
                            currentPrice = if (reserveState != ReserveState.NOT_APPLICABLE) it.priceDisplay else "",
                            displayPrice = it.priceDisplay,
                            buyNowPrice = it.buyNowPrice.toString(),
                            reserveState = when(reserveState) {
                                ReserveState.NOT_MET -> "Reserve not met"
                                ReserveState.MET -> "Reserve met"
                                ReserveState.NONE -> "No reserve"
                                else -> ""
                            }
                        )
                    }
                Result.success(productList)
            }
            catch (e: Throwable) {
                Result.failure(e)
            }
        }
}
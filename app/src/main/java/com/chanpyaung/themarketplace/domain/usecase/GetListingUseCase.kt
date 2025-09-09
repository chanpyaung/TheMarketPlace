package com.chanpyaung.themarketplace.domain.usecase

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
                        Product(
                            id = it.listingId,
                            title = it.title,
                            location = it.region,
                            currentPrice = it.priceDisplay,
                            buyNowPrice = it.buyNowPrice.toString(),
                            hasBuyNow = it.hasBuyNow,
                            isClassified = it.isClassified,
                            displayPrice = it.priceDisplay,
                            imageUrl = it.photoUrls.firstOrNull().orEmpty()
                        )
                    }
                Result.success(productList)
            }
            catch (e: Throwable) {
                Result.failure(e)
            }
        }
}
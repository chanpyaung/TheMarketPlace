package com.chanpyaung.themarketplace.data.repository

import com.chanpyaung.themarketplace.data.ApiService
import com.chanpyaung.themarketplace.data.models.ListingResponse
import com.chanpyaung.themarketplace.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DataRepository {
    suspend fun getListing(): ListingResponse
}

class DataRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : DataRepository {
    override suspend fun getListing(): ListingResponse {
        return withContext(ioDispatcher) {
            apiService.getLatestListings(emptyMap<String, String>()).body()!!
        }
    }
}
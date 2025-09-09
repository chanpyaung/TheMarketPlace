package com.chanpyaung.themarketplace.data

import com.chanpyaung.themarketplace.data.models.ListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("listings/latest.json")
    suspend fun getLatestListings(
        @QueryMap
        params: Map<String, @JvmSuppressWildcards Any>,
    ): Response<ListingResponse>

}
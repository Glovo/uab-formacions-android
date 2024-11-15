package com.glovoapp.uabformacions.dogapi.api

import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface BreedsAPI {

    @GET("breeds/list/all")
    suspend fun getBreeds(): BreedsResponse

    @Serializable
    data class BreedsResponse(
        val message: Map<String, Set<String>>,
    )

}

package com.sanketpatil.data.source.remote.api

import com.sanketpatil.data.source.remote.dto.ProductDto
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun getProduct(): List<ProductDto>
}
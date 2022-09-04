package com.sanketpatil.domain.dashboard.repository

import com.sanketpatil.data.source.remote.dto.ProductDto

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
}
package com.sanketpatil.data.repository

import com.sanketpatil.data.source.remote.api.ProductApi
import com.sanketpatil.data.source.remote.dto.ProductDto
import com.sanketpatil.domain.dashboard.repository.ProductRepository

class ProductRepositoryImp(val productApi: ProductApi) : ProductRepository {
    override suspend fun getProducts(): List<ProductDto> {
        return productApi.getProduct()
    }
}
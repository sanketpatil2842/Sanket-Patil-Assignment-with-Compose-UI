package com.sanketpatil.domain.dashboard.usecases

import com.sanketpatil.common.Resource
import com.sanketpatil.data.mapper.toProduct
import com.sanketpatil.domain.dashboard.model.Products
import com.sanketpatil.domain.dashboard.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductDashboardUsecase @Inject constructor(private val productRepository: ProductRepository) {

    operator fun invoke() = flow<Resource<Products>> {
        val response = productRepository.getProducts().map { it.toProduct() }
        emit(Resource.Success(data = response))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(message = it.localizedMessage))
    }

}
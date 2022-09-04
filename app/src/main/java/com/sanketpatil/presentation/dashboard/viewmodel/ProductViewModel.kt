package com.sanketpatil.presentation.dashboard.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanketpatil.common.Resource
import com.sanketpatil.domain.dashboard.model.ProductState
import com.sanketpatil.domain.dashboard.usecases.GetProductDashboardUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private var getProductDashboardUsecase: GetProductDashboardUsecase) :
    ViewModel() {

    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> = _state

    init {
        getDashboardProducts()
    }

    private fun getDashboardProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            getProductDashboardUsecase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = ProductState(data = result.data)
                    }
                    is Resource.Error -> {
                        _state.value = ProductState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = ProductState(isLoading = true)
                    }
                }
            }
        }
    }

}
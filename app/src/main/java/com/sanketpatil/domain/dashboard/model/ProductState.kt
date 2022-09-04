package com.sanketpatil.domain.dashboard.model

data class ProductState(
    val isLoading: Boolean = false,
    val data: List<Products>? = emptyList(),
    val error: String = ""
)

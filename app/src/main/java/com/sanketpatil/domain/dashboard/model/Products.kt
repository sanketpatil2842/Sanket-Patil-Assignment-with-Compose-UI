package com.sanketpatil.domain.dashboard.model

import com.sanketpatil.data.source.remote.dto.Rating

data class Products(
    val id: Int? = null,
    val title: String? = null,
    val price: String? = null,
    val description: String? = null,
    val category: String? = null,
    val image: String? = null,
    val rating: Rating? = null
)
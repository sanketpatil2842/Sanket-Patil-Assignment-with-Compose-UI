package com.sanketpatil.data.mapper

import com.sanketpatil.data.source.remote.dto.ProductDto
import com.sanketpatil.domain.dashboard.model.Products

fun ProductDto.toProduct(): Products {
    return Products(
        id = id,
        title = title,
        price = price.toString(),
        description = description,
        category = category,
        image = image,
        rating = rating
    )
}
package com.sanketpatil.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("rating")
    val rating: Rating? = null

)

data class Rating(@SerializedName("rate") val rate: Double, @SerializedName("count") val count: Int)
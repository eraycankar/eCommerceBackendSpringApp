package com.dev.ecommerce.dto

data class CreateProductDto(
    var name: String?,
    var unitPrice: Double ? = 0.0
)

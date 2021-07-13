package com.dev.ecommerce.dto


data class ProductDto(
    val id: Long?,
    val name: String?,
    val unitPrice: Double? = 0.0,
    val orderDetail: OrderDetailDto?
)

package com.dev.ecommerce.dto


data class ProductDto(
    var id: Long?,
    var name: String?,
    var unitPrice: Double? = 0.0,
    //var orderDetail: OrderDetailDto?
)

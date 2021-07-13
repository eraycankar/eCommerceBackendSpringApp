package com.dev.ecommerce.dto


data class OrderDetailDto(
    val id: Long?,
    val orders: OrdersDto?,
    val product: ProductDto?,
)

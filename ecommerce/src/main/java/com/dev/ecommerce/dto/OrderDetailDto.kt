package com.dev.ecommerce.dto


data class OrderDetailDto(
    var id: Long?,
    var orders: OrdersDto?,
    var product: ProductDto?,
)

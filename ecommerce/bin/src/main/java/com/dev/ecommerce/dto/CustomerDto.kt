package com.dev.ecommerce.dto

data class CustomerDto(
    val id: Long?,
    val name: String?,
    val mail: String?,
    val phone: String?,
    val orders: Set<OrdersDto>?
)

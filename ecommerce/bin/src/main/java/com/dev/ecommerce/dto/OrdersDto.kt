package com.dev.ecommerce.dto

import java.time.LocalDateTime

data class OrdersDto(
    val id: Long?,
    val creationDate: LocalDateTime?,
    val customer: CustomerDto?

)



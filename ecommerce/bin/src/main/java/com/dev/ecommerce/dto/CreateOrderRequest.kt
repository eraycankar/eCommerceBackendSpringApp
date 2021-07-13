package com.dev.ecommerce.dto

import java.time.LocalDateTime

data class CreateOrderRequest(
    val customerId: Long,
    val creationDate: LocalDateTime?

)

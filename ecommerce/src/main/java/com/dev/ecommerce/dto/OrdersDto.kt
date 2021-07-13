package com.dev.ecommerce.dto

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class OrdersDto(
    var id: Long?,
    var creationDate: LocalDate?,
    var customer: CustomerDto?

)



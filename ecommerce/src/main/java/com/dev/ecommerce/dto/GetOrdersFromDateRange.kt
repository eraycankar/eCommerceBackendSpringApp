package com.dev.ecommerce.dto

import java.time.LocalDate

data class GetOrdersFromDateRange(
    var id: Long?,
    var creationDate: LocalDate?,
)

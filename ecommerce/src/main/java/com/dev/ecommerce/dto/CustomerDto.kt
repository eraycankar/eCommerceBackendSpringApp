package com.dev.ecommerce.dto

import com.dev.ecommerce.model.Orders


data class CustomerDto(
    var id: Long?,
    var name: String?,
    var mail: String?,
    var phone: String?,
    //var orders: Set<Orders>?


)


package com.dev.ecommerce.model

import javax.persistence.*

@Entity
data class Product (
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var name: String?,
    var unitPrice: Double? = 0.0,

)

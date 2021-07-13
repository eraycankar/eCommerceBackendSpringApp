package com.dev.ecommerce.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Orders (
    @Id
    @Column(name = "ordersId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    val creationDate: LocalDateTime?,

   @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customerId")
    val customer: Customer?,
    //val totalAmount: Double? = 0.0
)

package com.dev.ecommerce.model
import java.util.HashSet
import javax.persistence.*

@Entity
data class Customer (
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String?,
    val mail: String?,
    val phone: String?,

   @OneToMany
    @JoinColumn(name = "ordersId")
    val orders: Set<Orders> = HashSet(0)
)
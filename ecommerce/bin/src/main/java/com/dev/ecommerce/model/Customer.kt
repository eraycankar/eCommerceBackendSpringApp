package com.dev.ecommerce.model
import javax.persistence.*

@Entity
data class Customer (
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var name: String?,
    var mail: String?,
    var phone: String?,


   @OneToMany(fetch = FetchType.LAZY , cascade = [CascadeType.ALL])
    @JoinColumn(name = "ordersId")
    val orders: List<Orders> = ArrayList()


)


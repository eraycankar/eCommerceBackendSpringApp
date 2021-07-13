package com.dev.ecommerce.model
import java.util.HashSet
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

   /*@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    var orders: Set<Orders>?*/
)
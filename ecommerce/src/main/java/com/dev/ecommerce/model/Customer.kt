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

   @ManyToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "orderId")
   @JoinTable(
        name = "customer_orders",
        joinColumns = [JoinColumn(name = "customerId")],
        inverseJoinColumns = [JoinColumn(name = "orderId")]
    )
    val order: Set<Order> = HashSet(0)
)
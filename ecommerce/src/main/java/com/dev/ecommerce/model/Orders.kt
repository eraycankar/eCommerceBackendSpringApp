package com.dev.ecommerce.model

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Orders (
    @Id
    @Column(name = "ordersId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,


    var creationDate: LocalDate?,

    @ManyToOne(fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    @JoinColumn(name = "customerId")
    var customer: Customer?,
    //val totalAmount: Double? = 0.0
){
    //constructor(customer: Customer, creationDate: LocalDateTime, ) : this(id = null,creationDate,customer = customer)
}





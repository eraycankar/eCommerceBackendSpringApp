package com.dev.ecommerce.repository;

import com.dev.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByCustomerId(Long customerId);
    List<Orders> findByCreationDateBetween(LocalDate from, LocalDate to);
}

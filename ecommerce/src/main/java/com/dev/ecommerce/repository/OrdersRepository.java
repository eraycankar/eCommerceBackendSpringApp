package com.dev.ecommerce.repository;



import com.dev.ecommerce.dto.GetOrdersFromDateRange;
import com.dev.ecommerce.dto.OrdersDto;
import com.dev.ecommerce.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByCustomerId(Long customerId);
    List<GetOrdersFromDateRange> findByCreationDateBetween(LocalDate from, LocalDate to);
}

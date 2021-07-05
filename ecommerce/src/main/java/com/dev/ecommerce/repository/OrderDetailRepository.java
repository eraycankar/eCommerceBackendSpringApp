package com.dev.ecommerce.repository;

import com.dev.ecommerce.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail,Long> {
}

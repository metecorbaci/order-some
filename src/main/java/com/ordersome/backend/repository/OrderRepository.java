package com.ordersome.backend.repository;

import com.ordersome.backend.model.Food;
import com.ordersome.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
    List<Order> findAll();

    @Query(value = "SELECT o.id, o.user_id, o.food_id, o.created_at " +
                    "FROM `order` as o " +
                    "LEFT JOIN `user` as u ON u.id = o.user_id " +
                    "LEFT JOIN food as f ON o.food_id = f.id " +
                    "WHERE u.email = :email" , nativeQuery = true)
    List<Order> findOrdersByUserEmail(@Param("email") String email);
}

package com.ordersome.backend.specification;

import com.ordersome.backend.model.Order;
import com.ordersome.backend.model.User;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
public class OrderSpecification {
    public static Specification<Order> hasOrderWithUserEmail(String email) {
        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            Join<User, Order> orders = root.join(User.ORDERS, JoinType.LEFT);
            return criteriaBuilder.equal(orders.get("user").get("email"), email);
        };
    }
}

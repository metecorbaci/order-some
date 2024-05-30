package com.ordersome.backend.controller;

import com.ordersome.backend.dto.OrderReqDto;
import com.ordersome.backend.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
// Swagger da gözükecek olan tag'in adı ve açıklaması
@Tag(name = "Order", description = "Order APIS")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderReqDto orderReqDto) {
        return orderService.createOrder(orderReqDto);
    }

    @GetMapping("/all")
    public ResponseEntity getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/by/mail")
    public ResponseEntity getOrderByEmail(@RequestParam String email) {
        return orderService.getOrderByEmail(email);
    }

}

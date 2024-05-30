package com.ordersome.backend.service;

import com.ordersome.backend.constant.ResponseMessages;
import com.ordersome.backend.dto.OrderReqDto;
import com.ordersome.backend.dto.OrderResDto;
import com.ordersome.backend.model.Food;
import com.ordersome.backend.model.Order;
import com.ordersome.backend.model.User;
import com.ordersome.backend.repository.FoodRepository;
import com.ordersome.backend.repository.OrderRepository;
import com.ordersome.backend.repository.UserRepository;
import com.ordersome.backend.specification.OrderSpecification;
import com.ordersome.backend.util.ResponseBody;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;

    public ResponseEntity createOrder(OrderReqDto orderReqDto) {
        try {
            User user = userRepository.findByEmail(orderReqDto.getUserMail());
            if (user == null) {
                return ResponseBody.send(ResponseMessages.USER_NOT_FOUND(), null, HttpStatus.NOT_FOUND);
            }
            Food food = foodRepository.findByName(orderReqDto.getFoodName());
            if (food == null) {
                return ResponseBody.send(ResponseMessages.FOOD_NOT_FOUND(), null, HttpStatus.NOT_FOUND);
            }
            Order order = new Order(user, food);
            Order savedOrder = orderRepository.save(order);
            OrderResDto responseData = new OrderResDto(
                    savedOrder.getUser().getFirstName() + " " + savedOrder.getUser().getLastName(),
                    savedOrder.getFood().getName(),
                    savedOrder.getFood().getPrice(),
                    savedOrder.getCreated_at());
            return ResponseBody.sendBody(ResponseMessages.ORDER_CREATED(), responseData , HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseBody.send(ResponseMessages.ORDER_ALREADY_EXISTS(), null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseBody.send(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity getAllOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
            List<OrderResDto> orderResDtos = new ArrayList<OrderResDto>();
            if (orders.isEmpty()) {
                return ResponseBody.send(ResponseMessages.ORDER_NOT_FOUND(), null, HttpStatus.NOT_FOUND);
            }
            orders.forEach(order -> {
                orderResDtos.add(new OrderResDto(order.getUser().getFirstName() + " " + order.getUser().getLastName(), order.getFood().getName(), order.getFood().getPrice(),order.getCreated_at()));
            });
            return ResponseBody.sendBody(ResponseMessages.GET_SUCCESS(), orderResDtos, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseBody.send(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity getOrderByEmail(String email) {
        try {
            List<Order> orders = orderRepository.findOrdersByUserEmail(email);
            List<OrderResDto> orderResDtos = new ArrayList<OrderResDto>();
            if (orders.isEmpty()) {
                return ResponseBody.send(ResponseMessages.ORDER_NOT_FOUND(), null, HttpStatus.NOT_FOUND);
            }
            orders.forEach(order -> {
                orderResDtos.add(new OrderResDto(order.getUser().getFirstName() + " " + order.getUser().getLastName(), order.getFood().getName(), order.getFood().getPrice(),order.getCreated_at()));
            });
            return ResponseBody.sendBody(ResponseMessages.GET_SUCCESS(), orderResDtos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseBody.send(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public OrderDao placeOrder(OrderDao order) throws Exception;
}

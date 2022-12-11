package com.example.demo.controller;


import com.example.demo.dao.OrderDao;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api/v1/order")
public class OrderController {

    private OrderService orderService;


    @GetMapping()
    public OrderDao saveOrder(@RequestBody OrderDao orderDao) throws Exception {
        return orderService.placeOrder(orderDao);
    }

}

package com.example.demo.service.ServiceImpl;

import com.example.demo.dao.OrderDao;
import com.example.demo.repository.OrderRepo;
import com.example.demo.service.OrderService;
import jakarta.persistence.criteria.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderDao placeOrder(OrderDao order) throws Exception {
        try{
            log.info("==================Set Hotel UUID==============");
            order.setId(UUID.randomUUID());
            this.orderRepo.save(order);
            return order;
        }catch (Exception e){
            throw new Exception("Provided menu is not found");
        }
    }
}

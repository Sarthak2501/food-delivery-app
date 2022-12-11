package com.example.demo.repository;

import com.example.demo.dao.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<OrderDao, UUID> {
}

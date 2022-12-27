package com.userService.userservice.Repository;

import com.userService.userservice.dao.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<OrderDao, UUID> {

}

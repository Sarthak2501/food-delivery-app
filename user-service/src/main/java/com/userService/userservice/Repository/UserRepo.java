package com.userService.userservice.Repository;

import com.userService.userservice.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<UserDao, UUID> {
    UserDao findByUserName(String name);

}


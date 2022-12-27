package com.userService.userservice.Repository;

import com.userService.userservice.dao.RoleDao;
import com.userService.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    RoleDao findByName(String name);
}

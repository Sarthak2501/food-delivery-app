package com.userService.userservice.Repository;

import com.userService.userservice.dao.Addressdao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Addressdao, UUID> {

}

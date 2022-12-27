package com.userService.userservice.model;

import com.userService.userservice.dao.Addressdao;
import com.userService.userservice.dao.RoleDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID userID;

    private String userName;

    private String emailId;

    private String password;

    private Addressdao adrress;

    private Collection<RoleDao> roles;
}


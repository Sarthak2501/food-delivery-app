package com.userService.userservice.service;

import com.userService.userservice.Repository.RoleRepo;
import com.userService.userservice.Repository.UserRepo;
import com.userService.userservice.dao.UserDao;
import com.userService.userservice.dao.RoleDao;
import com.userService.userservice.mapper.RoleMapper;
import com.userService.userservice.mapper.UserMapper;
import com.userService.userservice.model.Role;
import com.userService.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userRepo.findByUserName(username);
        if (user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in database");
        } else{
            log.info("User found in the database {} ",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
        {authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),authorities);
    }


    public UserDao saveUser(User user){
        return userRepo.save(userMapper.modelToDao(user));
    }


    public User updateUser(UUID userID, User user) throws Exception {
        UserDao userdao = userRepo.findById(userID).orElseThrow(() -> new Exception("user does not exist"));
        log.info("=====User added ====== {}",userdao);
        return userMapper.daoToModel(userRepo.save(userdao));
    }


    public List<User> findAll(){
        return userMapper.daoToModel(userRepo.findAll());
    }


    public void registerUser(UserDao userDao){
        this.userRepo.save(userDao);
    }

    public RoleDao saveRole(Role role) {
        log.info("Saving new role {} to the database",role.getName());
        return roleMapper.modelToDao(roleRepo.save(role));
    }


    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to user {}",roleName,username);
        UserDao appUser = userRepo.findByUserName(username);
        RoleDao role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }
}


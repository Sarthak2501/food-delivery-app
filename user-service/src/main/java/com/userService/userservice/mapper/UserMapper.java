package com.userService.userservice.mapper;


import com.userService.userservice.Repository.UserRepo;
import com.userService.userservice.dao.UserDao;
import com.userService.userservice.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private ModelMapper modelMapper = new ModelMapper();
    private final UserRepo userRepo;

    public UserMapper(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User daoToModel(UserDao userDao) {
        User user = null;
        if (!Objects.isNull(userDao)) {
            user = modelMapper.map(userDao, User.class); // (Source ,target)
            return user;
        }
        return user;
    }

    public List<User> daoToModel(List<UserDao> list) {
        return list.stream().map(x -> daoToModel(x)).collect(Collectors.toList());
    }

    public UserDao modelToDao(User user) {
        UserDao userDao = null;
        if (!Objects.isNull(user)) {
            userDao = modelMapper.map(user, UserDao.class); // (Source ,target)
            return userDao;
        }
        return userDao;

    }

    public List<UserDao> modelToDao(List<User> list) {
        return list.stream().map(x -> modelToDao(x)).collect(Collectors.toList());
    }

}

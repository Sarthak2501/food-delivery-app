package com.userService.userservice.mapper;

import com.userService.userservice.Repository.RoleRepo;
import com.userService.userservice.dao.RoleDao;
import com.userService.userservice.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    private ModelMapper modelMapper = new ModelMapper();

    private final RoleRepo roleRepo;

    public RoleMapper(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role daoToModel(RoleDao roleDao) {
        Role role = null;
        if (!Objects.isNull(roleDao)) {
            role = modelMapper.map(roleDao, Role.class); // (Source ,target)
            return role;
        }
        return role;
    }

    public List<Role> daoToModel(List<RoleDao> list) {
        return list.stream().map(x -> daoToModel(x)).collect(Collectors.toList());
    }

    public RoleDao modelToDao(Role role) {
        RoleDao roleDao = null;
        if (!Objects.isNull(role)) {
            roleDao = modelMapper.map(role, RoleDao.class); // (Source ,target)
            return roleDao;
        }
        return roleDao;

    }

    public List<RoleDao> modelToDao(List<Role> list) {
        return list.stream().map(x -> modelToDao(x)).collect(Collectors.toList());
    }
}

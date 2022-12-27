package com.userService.userservice.service;

import com.userService.userservice.Repository.AddressRepo;
import com.userService.userservice.Repository.UserRepo;
import com.userService.userservice.dao.Addressdao;
import com.userService.userservice.mapper.AddressMapper;
import com.userService.userservice.model.Address;
import com.userService.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    private AddressMapper addressMapper;


    public void saveAddress(Address address) {
        addressRepo.save(addressMapper.modelToDao(address));
    }

    public List<Address> getAllAddresses() {
        return addressMapper.daoToModel(addressRepo.findAll());
    }


    public Address getAddressById(UUID id) {
        return addressMapper.daoToModel(addressRepo.findById(id).get());
    }
}

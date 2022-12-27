package com.userService.userservice.mapper;


import com.userService.userservice.Repository.AddressRepo;
import com.userService.userservice.dao.Addressdao;
import com.userService.userservice.dao.UserDao;
import com.userService.userservice.model.Address;
import com.userService.userservice.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AddressMapper {

    private ModelMapper modelMapper = new ModelMapper();

    private final AddressRepo addressRepo;

    public AddressMapper(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }


    public Address daoToModel(Addressdao addressdao) {
        Address address = null;
        if (!Objects.isNull(addressdao)) {
            address = modelMapper.map(addressdao, Address.class); // (Source ,target)
            return address;
        }
        return address;
    }

    public List<Address> daoToModel(List<Addressdao> list) {
        return list.stream().map(x -> daoToModel(x)).collect(Collectors.toList());
    }

    public Addressdao modelToDao(Address address) {
        Addressdao addressdao = null;
        if (!Objects.isNull(address)) {
            addressdao = modelMapper.map(address, Addressdao.class); // (Source ,target)
            return addressdao;
        }
        return addressdao;
    }


    public List<Addressdao> modelToDao(List<Address> list) {
        return list.stream().map(x -> modelToDao(x)).collect(Collectors.toList());
    }

}

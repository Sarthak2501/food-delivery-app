package com.userService.userservice.controller;

import com.userService.userservice.model.Address;
import com.userService.userservice.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping()
    public ResponseEntity<List<Address>> getAllHotels() {
        log.info("==================getAllHotels==============");
        List<Address> lists = addressService.getAllAddresses();
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }

}

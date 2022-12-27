package com.userService.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private UUID addressID;

    private String HouseNumber;

    private String street;

    private String city;

    private String State;

    private long pinCode;

    private String landMark;
}

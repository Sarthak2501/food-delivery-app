package com.userService.userservice.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Long Id;

    private String restaurantName;

    private String restaurantCatalog;

    private List<FoodMenuDao> foodMenu;

    AddressDao address;
}

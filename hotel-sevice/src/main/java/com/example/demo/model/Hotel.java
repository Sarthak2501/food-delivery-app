package com.example.demo.model;

import com.example.demo.dao.AddressDao;
import com.example.demo.dao.FoodMenuDao;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

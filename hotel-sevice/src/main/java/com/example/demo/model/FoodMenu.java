package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenu {

    private Long Id;

    private String foodName;


    private String foodDescription;


    private String foodCatalog;


    private double foodPrice;
}

package com.example.demo.dao;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Food_Menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodMenuDao {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodMenu_Id")
    private UUID Id;


    @NotNull
    @Column(name = "food_name")
    private String foodName;


    @NotNull
    private String foodDescription;

    @NotNull
    private String foodCatalog;

    @NotNull
    @Column(name = "food_price")
    private double foodPrice;
}

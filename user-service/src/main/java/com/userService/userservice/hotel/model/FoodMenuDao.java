package com.userService.userservice.hotel.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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

package com.example.demo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "food_item")
@Entity
public class FoodItemDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodItem_Id")
    private UUID Id;

    @Column(name = "foodMenu_Id")
    private Long foodMenuID;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_price")
    private double foodPrice;

    private int quantity;
}

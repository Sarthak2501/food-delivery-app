package com.example.demo.dao;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hoteldao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_Id")
    private UUID hotelId;

    @NotNull
    private String restaurantName;

    @NotNull
    private String restaurantCatalog;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @JoinColumn(name = "hotel_Id")
    private List<FoodMenuDao> foodMenu;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    AddressDao address;
}

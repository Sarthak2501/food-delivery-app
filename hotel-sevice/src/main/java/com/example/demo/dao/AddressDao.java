package com.example.demo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Table(name = "Address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_Id")
    private UUID Id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country")
    private String country;

}

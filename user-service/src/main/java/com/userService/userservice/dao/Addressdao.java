package com.userService.userservice.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Addressdao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_ID")
    private UUID addressID;

    private String HouseNumber;

    private String street;

    private String city;

    private String State;

    private long pinCode;

    private String landMark;

}

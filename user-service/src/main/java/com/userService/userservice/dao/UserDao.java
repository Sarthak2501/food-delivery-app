package com.userService.userservice.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;


@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private UUID userID;

    private String userName;

    private String emailId;

    private String password;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Addressdao adrress;

    @ManyToMany(fetch = EAGER)
    private Collection<RoleDao> roles = new ArrayList<>();


}

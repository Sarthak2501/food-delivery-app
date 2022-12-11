package com.example.demo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order")
@Entity
public class OrderDao implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum OrderStatus {
        Created, Processing, Paid, Finished, Cancelld
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_Id")
    private UUID Id;

    @Column(name = "user-Name")
    private Long userName;

    @Column(name = "hotel_Id")
    private Long hotelId;

    @Column(name = "hotel_name")
    private String restaurantName;

    @Column(name = "order_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.Created;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @JoinColumn(name = "foodItem_Id")
    private List<FoodItemDao> foodItem;

}

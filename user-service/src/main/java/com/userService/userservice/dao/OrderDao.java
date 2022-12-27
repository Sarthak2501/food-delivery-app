package com.userService.userservice.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDao {

    public enum OrderStatus {
        Created, Processing, Paid, Finished, Canceled
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long Id;

    private float totalAmount;

    private Date timeStamp;

    private OrderStatus orderStatus = OrderStatus.Created;

}

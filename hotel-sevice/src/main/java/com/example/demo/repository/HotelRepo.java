package com.example.demo.repository;

import com.example.demo.dao.Hoteldao;
import com.example.demo.model.FoodMenu;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepo extends JpaRepository<Hoteldao,UUID> {

    @Query("select h.foodMenu from Hoteldao h where h.hotelId = :id")
    public List<FoodMenu> findAllMenuByHotelId(@Param("id") UUID id);
}

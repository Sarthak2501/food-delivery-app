package com.example.demo.service;

import com.example.demo.dao.Hoteldao;
import com.example.demo.model.FoodMenu;
import com.example.demo.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface HotelService {

    public Hotel addHotel(Hoteldao hoteldao) throws Exception;

    public Hotel update(UUID hotelId , Hoteldao hoteldao) throws Exception;

    public List<Hotel> findAll();

    public Optional<Hoteldao> getHotelById(UUID id);

    public List<FoodMenu>showFoodMenu(UUID hotelId);

}

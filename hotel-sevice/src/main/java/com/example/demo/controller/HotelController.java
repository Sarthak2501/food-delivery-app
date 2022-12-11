package com.example.demo.controller;


import com.example.demo.dao.Hoteldao;
import com.example.demo.model.FoodMenu;
import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@Controller
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @GetMapping()
    public ResponseEntity<List<Hotel>> getAllHotels() {
        log.info("==================getAllHotels==============");
        List<Hotel> hotels = hotelService.findAll();

        if (hotels.isEmpty()) {
            log.info("==================There is no hotel==============");
            return ResponseEntity.noContent().build();
        }
        log.info("==================all hotel Size:=============={}", hotels.size());
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody Hoteldao hoteldao) throws Exception {
        log.info("==================saveHotel============== {}", hoteldao);
        return new ResponseEntity<>(hotelService.addHotel(hoteldao), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{hotelId}/menu")
    public List<FoodMenu> showMenuByRestaurantId(@PathVariable UUID hotelId) {
        return hotelService.showFoodMenu(hotelId);
    }
}

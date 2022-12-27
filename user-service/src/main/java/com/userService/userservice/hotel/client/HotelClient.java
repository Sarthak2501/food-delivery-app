package com.userService.userservice.hotel.client;


import com.userService.userservice.hotel.model.Hotel;
import org.springframework.http.ResponseEntity;
import retrofit2.http.GET;

import java.util.List;

public interface HotelClient {

    @GET("/api/v1/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels();

}

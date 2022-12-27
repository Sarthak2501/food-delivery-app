package com.userService.userservice.hotel.gateway;


import com.userService.userservice.hotel.client.HotelClient;
import com.userService.userservice.hotel.model.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import retrofit2.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Configuration
public class HotelGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelGateway.class);

    private final Locale currentLocale = LocaleContextHolder.getLocale();

    private final MessageSource messageSource;
    private final HotelClient hotelClient;

    @Autowired
    public HotelGateway(final MessageSource messageSource, HotelClient hotelClient) {
        this.messageSource = messageSource;
        this.hotelClient = hotelClient;
    }


    @Cacheable(value = "hotels")
    public ResponseEntity<List<Hotel>> getAllHotel() {
        ResponseEntity<List<Hotel>> response = hotelClient.getAllHotels();
        if (response.hashCode() == HttpStatus.OK.value()) {
            LOGGER.info("Get all hotels: {}", response);
            return response;
        } else
            return null;
    }
}

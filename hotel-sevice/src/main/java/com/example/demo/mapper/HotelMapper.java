package com.example.demo.mapper;


import com.example.demo.dao.Hoteldao;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepo;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    private ModelMapper modelMapper = new ModelMapper();
    private final HotelRepo hotelRepo;

    public HotelMapper(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public Hotel daoToModel(Hoteldao hoteldao) {
        Hotel hotel = null;
        if (!Objects.isNull(hoteldao)) {
            hotel = modelMapper.map(hoteldao, Hotel.class); // (Source ,target)
            return hotel;
        }
        return hotel;
    }

    public List<Hotel> daoToModel(List<Hoteldao> list) {
        return list.stream().map(x -> daoToModel(x)).collect(Collectors.toList());
    }

    public Hoteldao modelToDao(Hotel hotel) {

        Hoteldao hoteldao = null;
        if (!Objects.isNull(hotel)) {
            hoteldao = modelMapper.map(hotel, Hoteldao.class); // (Source ,target)
            return hoteldao;
        }
        return hoteldao;

    }

    public List<Hoteldao> modelToDao(List<Hotel> list) {
        return list.stream().map(x -> modelToDao(x)).collect(Collectors.toList());
    }

}

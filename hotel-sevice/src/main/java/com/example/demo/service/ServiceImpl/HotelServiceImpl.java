package com.example.demo.service.ServiceImpl;

import com.example.demo.dao.Hoteldao;
import com.example.demo.mapper.HotelMapper;
import com.example.demo.model.FoodMenu;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepo;
import com.example.demo.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class HotelServiceImpl implements HotelService {

    private HotelRepo hotelRepo;

    private HotelMapper hotelMapper;



    @Autowired
    public HotelServiceImpl(HotelRepo hotelRepo, HotelMapper hotelMapper) {
        this.hotelRepo = hotelRepo;
        this.hotelMapper = hotelMapper;
    }


    @Override
    public Hotel addHotel(Hoteldao hoteldao) throws Exception {
        try{
            log.info("==================Set Hotel UUID==============");
            hoteldao.setHotelId(UUID.randomUUID());
            this.hotelRepo.save(hoteldao);
            return hotelMapper.daoToModel(hoteldao);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Hotel update(UUID HotelId, Hoteldao hoteldao) throws Exception {
        Hoteldao hoteldao1 = hotelRepo.findById(HotelId)
                .orElseThrow(() -> new Exception("hotel does not exist"));
        log.info("=====hotel added ====== {}",hoteldao1);
        return hotelMapper.daoToModel(hotelRepo.save(hoteldao1));
    }

    @Override
    public List<Hotel> findAll() {
        log.info("==================getAllHotel==============");
        return hotelMapper.daoToModel(hotelRepo.findAll());
    }

    @Override
    public Optional<Hoteldao> getHotelById(UUID id) {
        log.info("==================getHotelById- Using hotel Id==============" + id);
        return hotelRepo.findById(id);
    }

    @Override
    public List<FoodMenu> showFoodMenu(UUID hotelId) {
        return hotelRepo.findAllMenuByHotelId(hotelId);
    }
}

//name:9504289289
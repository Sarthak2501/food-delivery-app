package com.example.demo.service.ServiceImpl;

import com.example.demo.dao.FoodMenuDao;
import com.example.demo.dao.Hoteldao;
import com.example.demo.mapper.FoodMapper;
import com.example.demo.model.FoodMenu;
import com.example.demo.repository.FoodMenuRepo;
import com.example.demo.service.FoodMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class FoodMenuServiceImpl implements FoodMenuService {

    private FoodMenuRepo foodMenuRepo;

    private FoodMapper foodMapper;

    @Autowired
    public FoodMenuServiceImpl(FoodMenuRepo foodMenuRepo, FoodMapper foodMapper) {
        this.foodMenuRepo = foodMenuRepo;
        this.foodMapper = foodMapper;
    }

    @Override
    public FoodMenu addFoodMenu(FoodMenuDao foodMenuDao) throws Exception {
        try{
            log.info("==================Set Hotel UUID==============");
            foodMenuDao.setId(UUID.randomUUID());
            this.foodMenuRepo.save(foodMenuDao);
            return foodMapper.daoToModel(foodMenuDao);
        }catch (Exception e){
            throw new Exception("Provided food menu is already present");
        }
    }

    @Override
    public FoodMenu update(UUID id,FoodMenuDao foodMenudao) throws Exception {
        FoodMenuDao foodMenudao1 = foodMenuRepo.findById(id)
                .orElseThrow(() -> new Exception("food does not exist"));
        log.info("=====food menu added ====== {}",foodMenudao1);
        return foodMapper.daoToModel(foodMenuRepo.save(foodMenudao1));
    }

    @Override
    public List<FoodMenu> findAll() {
        log.info("==================getAllFoodMenu==============");
        return foodMapper.daoToModel(foodMenuRepo.findAll());
    }

    @Override
    public Optional<FoodMenuDao> getFoodById(UUID id) {
        log.info("==================getHotelById- Using hotel Id==============" + id);
        return foodMenuRepo.findById(id);
    }

    @Override
    public List<FoodMenu> findAllMenuByResturantID(Long hotelId) {
        return null;
    }
}

package com.example.demo.service;

import com.example.demo.dao.FoodMenuDao;
import com.example.demo.model.FoodMenu;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface FoodMenuService {

    public FoodMenu addFoodMenu(FoodMenuDao foodMenuDao) throws Exception;

    public FoodMenu update(UUID id , FoodMenuDao foodMenudao) throws Exception;

    public List<FoodMenu> findAll();

    public Optional<FoodMenuDao> getFoodById(UUID id);

    public List<FoodMenu>findAllMenuByResturantID(Long hotelId);
}

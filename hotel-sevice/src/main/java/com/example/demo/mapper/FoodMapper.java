package com.example.demo.mapper;


import com.example.demo.dao.FoodMenuDao;
import com.example.demo.dao.Hoteldao;
import com.example.demo.model.FoodMenu;
import com.example.demo.model.Hotel;
import com.example.demo.repository.FoodMenuRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FoodMapper {

    private ModelMapper modelMapper = new ModelMapper();
    private final FoodMenuRepo foodMenuRepo;

    public FoodMapper(FoodMenuRepo foodMenuRepo) {
        this.foodMenuRepo = foodMenuRepo;
    }

    public FoodMenu daoToModel(FoodMenuDao foodMenuDao) {
        FoodMenu foodMenu = null;
        if (!Objects.isNull(foodMenuDao)) {
            foodMenu = modelMapper.map(foodMenuDao, FoodMenu.class); // (Source ,target)
            return foodMenu;
        }
        return foodMenu;
    }

    public List<FoodMenu> daoToModel(List<FoodMenuDao> list) {
        return list.stream().map(x -> daoToModel(x)).collect(Collectors.toList());
    }

    public FoodMenuDao modelToDao(FoodMenu foodMenu) {

        FoodMenuDao foodMenuDao = null;
        if (!Objects.isNull(foodMenu)) {
            foodMenuDao = modelMapper.map(foodMenu, FoodMenuDao.class); // (Source ,target)
            return foodMenuDao;
        }
        return foodMenuDao;

    }

    public List<FoodMenuDao> modelToDao(List<FoodMenu> list) {
        return list.stream().map(x -> modelToDao(x)).collect(Collectors.toList());
    }

}

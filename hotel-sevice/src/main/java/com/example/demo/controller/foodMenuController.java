package com.example.demo.controller;


import com.example.demo.dao.FoodMenuDao;
import com.example.demo.dao.Hoteldao;
import com.example.demo.model.FoodMenu;
import com.example.demo.model.Hotel;
import com.example.demo.service.FoodMenuService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("api/v1/food-menu")
public class foodMenuController {

    @Autowired
    private FoodMenuService foodMenuService;

    @PostMapping()
    public ResponseEntity<FoodMenu> addFoodMenu(@Valid @RequestBody FoodMenuDao foodMenuDao) throws Exception {
        return new ResponseEntity<>(foodMenuService.addFoodMenu(foodMenuDao), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FoodMenu>> getAllFoodMenu(){
        List<FoodMenu> foodMenu = foodMenuService.findAll();
        if (foodMenu.isEmpty()) {
            log.info("==================There is no food in menu==============");
            return ResponseEntity.noContent().build();
        }
        log.info("==================all menu Size:=============={}", foodMenu.size());
        return new ResponseEntity<>(foodMenu, HttpStatus.OK);
    }
}

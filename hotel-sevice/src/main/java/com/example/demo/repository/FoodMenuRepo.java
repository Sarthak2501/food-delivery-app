package com.example.demo.repository;

import com.example.demo.dao.FoodMenuDao;
import com.example.demo.model.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodMenuRepo extends JpaRepository<FoodMenuDao, UUID> {

}

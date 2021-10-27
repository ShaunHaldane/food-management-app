package com.shaunhaldane.foodmanagementappthymeleaf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaunhaldane.foodmanagementappthymeleaf.models.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

	List<FoodItem> findAllByUserName(String username);
}

package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import com.shaunhaldane.foodmanagementappthymeleaf.models.FoodItem;

public interface FoodItemService {
	
	public List<FoodItem> getAll(String username);
	
	public FoodItem getById(int id);

	public void saveOrUpdate(FoodItem FoodItem, String username);

	public void delete(int id);

}

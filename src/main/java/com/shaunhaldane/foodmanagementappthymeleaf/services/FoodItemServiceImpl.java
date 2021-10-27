package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunhaldane.foodmanagementappthymeleaf.models.FoodItem;
import com.shaunhaldane.foodmanagementappthymeleaf.repositories.FoodItemRepository;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Override
	public List<FoodItem> getAll(String username) {
		return foodItemRepository.findAllByUserName(username);
	}

	@Override
	public FoodItem getById(int id) {
		return foodItemRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(FoodItem FoodItem, String username) {
		FoodItem.setUserName(username);
		foodItemRepository.save(FoodItem);
	}

	@Override
	public void delete(int id) {
		foodItemRepository.deleteById(id);
	}
}


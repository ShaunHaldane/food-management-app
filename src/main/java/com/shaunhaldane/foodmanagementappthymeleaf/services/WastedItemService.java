package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import com.shaunhaldane.foodmanagementappthymeleaf.models.WastedItem;

public interface WastedItemService {
	
	public List<WastedItem> getAll(String username);
	
	public WastedItem getById(int id);
	
	public void saveOrUpdate(WastedItem wastedItem, String username);
	
	public void delete(int id);

	public List<WastedItem> getAllForAdmin();

}

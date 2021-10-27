package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import com.shaunhaldane.foodmanagementappthymeleaf.models.Backlog;

public interface BacklogService {
	
	public List<Backlog> getAll(String username);
	
	public Backlog getById(int id);
	
	public void saveOrUpdate(Backlog backlog, String username);
	
	public void delete(int id);

	public List<Backlog> getAllForAdmin();

}

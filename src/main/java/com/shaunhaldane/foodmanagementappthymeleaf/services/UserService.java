package com.shaunhaldane.foodmanagementappthymeleaf.services;

import com.shaunhaldane.foodmanagementappthymeleaf.models.User;

public interface UserService {

	public void createNewAccount(User user);
	
	public boolean loginExists(String login);
	
}

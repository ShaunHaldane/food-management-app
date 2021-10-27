package com.shaunhaldane.foodmanagementappthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaunhaldane.foodmanagementappthymeleaf.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public boolean existsByLogin(String login);
	
	public User findByLogin(String login);
	
}

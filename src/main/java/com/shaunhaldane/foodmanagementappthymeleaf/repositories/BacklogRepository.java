package com.shaunhaldane.foodmanagementappthymeleaf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaunhaldane.foodmanagementappthymeleaf.models.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Integer>{
	
	List<Backlog> findAllByUserName(String username);

}

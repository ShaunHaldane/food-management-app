package com.shaunhaldane.foodmanagementappthymeleaf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaunhaldane.foodmanagementappthymeleaf.models.WastedItem;

@Repository
public interface WastedItemRepository extends JpaRepository<WastedItem, Integer>{
	
	List<WastedItem> findAllByUserName(String username);

}

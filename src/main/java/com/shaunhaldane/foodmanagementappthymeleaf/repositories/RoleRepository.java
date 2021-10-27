package com.shaunhaldane.foodmanagementappthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaunhaldane.foodmanagementappthymeleaf.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

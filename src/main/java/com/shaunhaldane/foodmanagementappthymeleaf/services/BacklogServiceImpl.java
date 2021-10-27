package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunhaldane.foodmanagementappthymeleaf.models.Backlog;
import com.shaunhaldane.foodmanagementappthymeleaf.repositories.BacklogRepository;

@Service
@Transactional
public class BacklogServiceImpl implements BacklogService {
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Override
	public List<Backlog> getAll(String username) {
		return backlogRepository.findAllByUserName(username);
	}

	@Override
	public Backlog getById(int id) {
		return backlogRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Backlog backlog, String username) {
		backlog.setUserName(username);
		backlogRepository.save(backlog);
	}

	@Override
	public void delete(int id) {
		backlogRepository.deleteById(id);
	}

	public List<Backlog> getAllForAdmin() {
		return backlogRepository.findAll();
	}
}

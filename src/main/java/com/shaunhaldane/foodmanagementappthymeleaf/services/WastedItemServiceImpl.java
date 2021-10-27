package com.shaunhaldane.foodmanagementappthymeleaf.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunhaldane.foodmanagementappthymeleaf.models.WastedItem;
import com.shaunhaldane.foodmanagementappthymeleaf.repositories.WastedItemRepository;

@Service
@Transactional
public class WastedItemServiceImpl implements WastedItemService {

	@Autowired
	private WastedItemRepository wastedItemRepository;

	/*
	 * @Autowired private UserRepository userRepository;
	 */
	
	@Override
	public List<WastedItem> getAll(String username) {
		return wastedItemRepository.findAllByUserName(username);
	}

	@Override
	public WastedItem getById(int id) {
		return wastedItemRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(WastedItem wastedItem, String username) {
		wastedItem.setUserName(username);
		wastedItemRepository.save(wastedItem);
	}

	@Override
	public void delete(int id) {
		wastedItemRepository.deleteById(id);
	}

	public List<WastedItem> getAllForAdmin() {
		return wastedItemRepository.findAll();
	}
}

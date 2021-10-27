package com.shaunhaldane.foodmanagementappthymeleaf.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shaunhaldane.foodmanagementappthymeleaf.models.Backlog;
import com.shaunhaldane.foodmanagementappthymeleaf.models.FoodItem;
import com.shaunhaldane.foodmanagementappthymeleaf.models.WastedItem;
import com.shaunhaldane.foodmanagementappthymeleaf.services.BacklogService;
import com.shaunhaldane.foodmanagementappthymeleaf.services.FoodItemService;
import com.shaunhaldane.foodmanagementappthymeleaf.services.WastedItemService;

@Controller
public class MainController {
	
	@Autowired
	private FoodItemService foodItemService;
	
	@Autowired
	private BacklogService backlogService;
	
	@Autowired
	private WastedItemService wastedItemService;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/privacyPolicy")
	public String getPrivacyPolicy() {
		return "privacy-policy";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model, Principal principal) {
		List<FoodItem> foodItems = foodItemService.getAll(principal.getName());
		model.addAttribute("foodItems", foodItems);
		return "dashboard";
	}
	
	@GetMapping("/addFoodItem")
	public String showAddItemForm(Model model, Principal principal) {
		model.addAttribute("foodItem", new FoodItem());
		return "add-item-form";
	}
	
	@PostMapping("/processAddItemForm")
	public String createFoodItem(@Valid @ModelAttribute FoodItem foodItem, Backlog backlog, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "add-item-form";
		}
    	foodItemService.saveOrUpdate(foodItem, principal.getName());
    	backlog.setItem(foodItem.getItem());
    	backlog.setPrice(foodItem.getPrice());
    	backlog.setPurchaseDate(foodItem.getPurchaseDate());
		backlogService.saveOrUpdate(backlog, principal.getName());
		return "redirect:dashboard";
	}
	
	@GetMapping("/editFoodItem/{id}")
	public String editFoodItem(@PathVariable int id, Model model) {
		FoodItem foodItem = foodItemService.getById(id);
		Backlog backlog = backlogService.getById(id);
		if(foodItem != null) {
			model.addAttribute("foodItem", foodItem);
			return "add-item-form";
		}
		if(backlog != null) {
			model.addAttribute("backlog", backlog);
			return "add-item-form";
		}
		return "redirect:/dashboard";
	}

	@GetMapping("/wastedFoodItem/{id}")
	public String wastedFoodItem(@PathVariable int id, Principal principal) {
		FoodItem foodItem = foodItemService.getById(id);
		WastedItem wastedItem = new WastedItem(foodItem.getItem(), foodItem.getPrice());
		wastedItemService.saveOrUpdate(wastedItem, principal.getName());
		if(foodItem != null) {
			foodItemService.delete(id);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/usedFoodItem/{id}")
	public String usedFoodItem(@PathVariable int id, Principal principal) {
		FoodItem foodItem = foodItemService.getById(id);
		if(foodItem != null) {
			foodItemService.delete(id);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/graphs")
	public String getMoneySpentThisYearGraph(Model backlogModel, Model wastedItemsModel, Principal principal) {
		List<Backlog> backlogList = backlogService.getAll(principal.getName());
		List<WastedItem> wastedItems = wastedItemService.getAll(principal.getName());
		backlogModel.addAttribute("backlogList", backlogList);
		wastedItemsModel.addAttribute("wastedItems", wastedItems);
		return "graphs";
	}
	
}

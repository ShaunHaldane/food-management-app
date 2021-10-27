package com.shaunhaldane.foodmanagementappthymeleaf.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shaunhaldane.foodmanagementappthymeleaf.services.FoodItemService;

@Entity
public class FoodItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Item name is required")
	private String item;
	
	@NotBlank(message = "Expiry date is required")
	@Size(min=10, max=10, message="Use the following format: dd-mm-yyyy")
	private String expiryDate;
	
	@NotNull(message= "Price of the item is required")
	private float price;

	private LocalDate purchaseDate = java.time.LocalDate.now();
	
	// Connects food item list table to user table
	@ManyToOne
	@JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
	
	// Used to connect certain food items in table to particular user
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

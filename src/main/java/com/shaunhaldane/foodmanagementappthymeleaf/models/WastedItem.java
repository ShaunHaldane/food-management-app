package com.shaunhaldane.foodmanagementappthymeleaf.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WastedItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String item;
	
	private float price;
	
	@Column(name="wasted_date")
	private LocalDate wastedDate = java.time.LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name="user_id")
    private User user;
	
	private String userName;
	
	public WastedItem() {
	}
	
	public WastedItem(String item, float price) {
		this.item = item;
		this.price = price;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getWastedDate() {
		return wastedDate;
	}

	public void setWastedDate(LocalDate wastedDate) {
		this.wastedDate = wastedDate;
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

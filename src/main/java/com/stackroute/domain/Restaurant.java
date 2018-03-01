package com.stackroute.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Restaurant {

	private String restaurantName;
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// to understand above line
	private int id;
	private String restaurantLocation;
	private BigDecimal costOfTwo;

	//
	// public Restaurant(String restaurantName, int id, String
	// restaurantLocation, BigDecimal costOfTwo) {
	// this.restaurantName = restaurantName;
	// this.id = id;
	// this.restaurantLocation = restaurantLocation;
	// this.costOfTwo = costOfTwo;
	// }

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public BigDecimal getCostOfTwo() {
		return costOfTwo;
	}

	public void setCostOfTwo(BigDecimal costOfTwo) {
		this.costOfTwo = costOfTwo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

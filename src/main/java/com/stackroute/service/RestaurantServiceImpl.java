package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;
import com.stackroute.repositories.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	RestaurantRepository restaurantRepository;

	@Autowired
	public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	public Restaurant findById(int id) {
		return restaurantRepository.findById(id);

	}

	public List<Restaurant> findAll() {
		return (List<Restaurant>) restaurantRepository.findAll();

	}

	public String deleteRestaurant(int restaurantId) {
		restaurantRepository.delete(restaurantId);
		return "restaurant deleted";

	}

	public Restaurant findByRestaurantName(String restaurantName) {
		return restaurantRepository.findByRestaurantName(restaurantName);

	}

	public RestaurantRepository getRestaurantRepository() {
		return restaurantRepository;
	}

}

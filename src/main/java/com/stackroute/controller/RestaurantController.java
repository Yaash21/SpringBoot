package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Restaurant;
import com.stackroute.service.RestaurantService;

@RestController
@RequestMapping("/api/v1")

public class RestaurantController {

	RestaurantService restaurantService;

	@Autowired
	// @Qualifier("restaurantServiceImpl")
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant addedRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.CREATED);
		// System.out.println(ResponseEntity<Restaurant>.);

	}

	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int restaurantId) {
		String delete = restaurantService.deleteRestaurant(restaurantId);
		return new ResponseEntity<String>(delete, HttpStatus.OK);

	}

	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> searchById(@PathVariable int id) {
		Restaurant searchRestaurant = restaurantService.searchById(id);
		return new ResponseEntity<Restaurant>(searchRestaurant, HttpStatus.OK);

	}

	@RequestMapping("/restaurant")
	public ResponseEntity<List<Restaurant>> findAllRestaurant() {
		List<Restaurant> listOfRestaurant = restaurantService.findAll();
		return new ResponseEntity<List<Restaurant>>(listOfRestaurant, HttpStatus.OK);

	}

	@RequestMapping(value = "/restaurant", params = "name")
	public ResponseEntity<Restaurant> searchByRestaurantName(@RequestParam("name") String restaurantName) {
		Restaurant searchByRestaurantName = restaurantService.findByRestaurantName(restaurantName);
		return new ResponseEntity<Restaurant>(searchByRestaurantName, HttpStatus.OK);

	}

}

package com.car.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.service.entities.CarEntity;
import com.car.service.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	public ResponseEntity<List<CarEntity>> carList(){
		List<CarEntity> cars = carService.getAll();
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarEntity> getCar(@PathVariable Integer id){
		CarEntity car = carService.getCarById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@PostMapping
	public ResponseEntity<CarEntity> saveCar(@RequestBody CarEntity car){
		CarEntity newCar = carService.save(car);
		return ResponseEntity.ok(newCar);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<CarEntity>> carListByUserId(@PathVariable Integer id){
		List<CarEntity> cars = carService.getAllByUserId(id);
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}
	
}

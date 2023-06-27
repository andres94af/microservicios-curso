package com.usuario.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entities.UserEntity;
import com.usuario.service.models.Car;
import com.usuario.service.models.Moto;
import com.usuario.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserEntity>> userList() {
		List<UserEntity> users = this.userService.getAll();
		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
		UserEntity user = this.userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
		UserEntity newUser = this.userService.save(user);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/cars/{usuarioId}")
	public ResponseEntity<List<Car>> carsList(@PathVariable Integer usuarioId) {
		UserEntity user = userService.getUserById(usuarioId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		List<Car> cars = userService.getCarsByUserId(usuarioId);
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/motos/{userId}")
	public ResponseEntity<List<Moto>> motosList(@PathVariable Integer userId) {
		UserEntity user = userService.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		List<Moto> motos = userService.getMotosByUserId(userId);
		return ResponseEntity.ok(motos);
	}

	@PostMapping("/car/{userId}")
	public ResponseEntity<Car> saveCarToUser(@PathVariable Integer userId, @RequestBody Car car) {
		UserEntity user = userService.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		Car newCar = userService.saveCar(userId, car);
		return ResponseEntity.ok(newCar);
	}
	
	@PostMapping("/moto/{userId}")
	public ResponseEntity<Moto> saveMotoToUser(@PathVariable Integer userId, @RequestBody Moto moto) {
		UserEntity user = userService.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		Moto newMoto = userService.saveMoto(userId, moto);
		return ResponseEntity.ok(newMoto);
	}
	
	@GetMapping("/all/{userId}")
	public ResponseEntity<Map<String, Object>> getAllVehiclesOfUser(@PathVariable Integer userId){
		Map<String, Object> vehicles = userService.getUsersAndVehicles(userId);
		return ResponseEntity.ok(vehicles);
	}
}

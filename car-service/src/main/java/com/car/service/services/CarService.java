package com.car.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.service.entities.CarEntity;
import com.car.service.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	public List<CarEntity> getAll(){
		return repository.findAll();
	}
	
	public CarEntity getCarById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public CarEntity save(CarEntity car) {
		return repository.save(car);
	}
	
	public List<CarEntity> getAllByUserId (Integer id){
		return repository.findByUserId(id);
	}
	
}

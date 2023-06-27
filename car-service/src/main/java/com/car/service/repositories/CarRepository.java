package com.car.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.service.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>{
	
	List<CarEntity> findByUserId(Integer userId);

}

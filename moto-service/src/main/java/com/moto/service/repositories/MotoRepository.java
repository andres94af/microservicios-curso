package com.moto.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.service.entities.MotoEntity;

@Repository
public interface MotoRepository extends JpaRepository<MotoEntity, Integer> {

	List<MotoEntity> findByUserId(Integer id);

}

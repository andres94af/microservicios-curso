package com.moto.service.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entities.MotoEntity;
import com.moto.service.repositories.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository repository;

	public List<MotoEntity> getAll() {
		return repository.findAll();
	}

	public MotoEntity getUserById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public MotoEntity save(MotoEntity moto) {
		return repository.save(moto);
	}

	public List<MotoEntity> getAllByUserId(Integer id) {
		return repository.findByUserId(id);
	}
}

package com.example.aeon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aeon.models.entities.Training;
import com.example.aeon.models.repositories.TrainingRepo;

@Service
@Transactional
public class TrainingService {

	@Autowired
	private TrainingRepo trainingRepo;
	
	public Training save(Training training) {
		return trainingRepo.save(training);
	}
	
	public Training findOne(Long id) {
		Optional<Training> training = trainingRepo.findById(id);
		if(!training.isPresent()) {
			return null;
		}
		return training.get();
	}
	
	public Iterable<Training> findByNama(String nama, Pageable pageable){
		return trainingRepo.findByTemaContains(nama, pageable);
	}
}

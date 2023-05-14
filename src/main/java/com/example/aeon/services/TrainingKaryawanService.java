package com.example.aeon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aeon.models.entities.Karyawan;
import com.example.aeon.models.entities.KaryawanTraining;
import com.example.aeon.models.entities.Training;
import com.example.aeon.models.repositories.TrainingKaryawanRepo;

@Service
@Transactional
public class TrainingKaryawanService {
	@Autowired
	private TrainingKaryawanRepo trainingKaryawanRepo;
	
	public KaryawanTraining save(KaryawanTraining karyawanTraining)  {
		return trainingKaryawanRepo.save(karyawanTraining);
	}
	
	public Iterable<KaryawanTraining> findAll(Pageable pageable){
		return trainingKaryawanRepo.findAll(pageable);
	}
}

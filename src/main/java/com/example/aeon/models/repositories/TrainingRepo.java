package com.example.aeon.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aeon.models.entities.Training;

public interface TrainingRepo extends JpaRepository<Training, Long>{
	Page<Training> findByTemaContains(String nama, Pageable pageable);
}

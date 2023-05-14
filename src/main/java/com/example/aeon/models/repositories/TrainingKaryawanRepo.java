package com.example.aeon.models.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aeon.models.entities.KaryawanTraining;

public interface TrainingKaryawanRepo extends JpaRepository<KaryawanTraining, Long>{

}

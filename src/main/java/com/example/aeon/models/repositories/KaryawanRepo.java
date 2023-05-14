package com.example.aeon.models.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.aeon.models.entities.Karyawan;

public interface KaryawanRepo extends JpaRepository<Karyawan, Long>{
	
//	List<Karyawan> findByNameContains(String name);
	Page<Karyawan> findByNamaContains(String nama, Pageable pageable);
}

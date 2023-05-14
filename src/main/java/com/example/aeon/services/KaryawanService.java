package com.example.aeon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.aeon.models.entities.Karyawan;
import com.example.aeon.models.repositories.KaryawanRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class KaryawanService {
	
	@Autowired
	private KaryawanRepo karyawanRepo;

	public Karyawan save(Karyawan karyawan) {
		return karyawanRepo.save(karyawan);
	}
	
	public Karyawan findOne(Long id) {
		Optional<Karyawan> karyawan = karyawanRepo.findById(id);
		if(!karyawan.isPresent()) {
			return null;
		}
		return karyawan.get();
	}
	
	public void removeOne(Long id) {
		karyawanRepo.deleteById(id);
	}
	
	public Iterable<Karyawan> findByName(String nama, Pageable pageable){
		return karyawanRepo.findByNamaContains(nama, pageable);
	}
}

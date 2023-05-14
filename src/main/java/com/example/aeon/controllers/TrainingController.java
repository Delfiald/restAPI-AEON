package com.example.aeon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aeon.dto.ResponseData;
import com.example.aeon.dto.SearchData;
import com.example.aeon.models.entities.Training;
import com.example.aeon.services.TrainingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/training")
public class TrainingController {
	
	@Autowired
	private TrainingService trainingService;
	
	@PostMapping
	public ResponseEntity<ResponseData<Training>> create(@Valid @RequestBody Training training, Errors errors) {
		ResponseData<Training> responseData = new ResponseData<>();
		
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		responseData.setStatus(true);
		responseData.setPayload(trainingService.save(training));
		return ResponseEntity.ok(responseData);
	}
	
	@PutMapping
	public ResponseEntity<ResponseData<Training>> update(@Valid @RequestBody Training training, Errors errors) {
		ResponseData<Training> responseData = new ResponseData<>();
		
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		responseData.setStatus(true);
		responseData.setPayload(trainingService.save(training));
		return ResponseEntity.ok(responseData);
	}
	
	@GetMapping("/{id}")
	public Training findOne(@PathVariable ("id") Long id) {
		return trainingService.findOne(id);
	}
	
	@GetMapping("/list/{size}/{page}")
	public Iterable<Training> findByNama(@RequestBody SearchData searchData, @PathVariable ("size") int size, @PathVariable ("page") int page) {
		Pageable pageable = PageRequest.of(page, size);
		return trainingService.findByNama(searchData.getSearchKey(), pageable);
	}
}

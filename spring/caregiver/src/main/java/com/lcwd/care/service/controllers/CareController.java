package com.lcwd.care.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.care.service.entities.Care;
import com.lcwd.care.service.services.CareService;

@RestController
@RequestMapping("/cares")
@CrossOrigin("*")
public class CareController {

	
	@Autowired
    private CareService careService;
	
	 @PostMapping
	    public ResponseEntity<Care> createCare(@RequestBody Care care) {
	        Care care1 = careService.saveCare(care);
	        return ResponseEntity.status(HttpStatus.CREATED).body(care1);
	    }
	 
	 @GetMapping("/{careId}")
	 public ResponseEntity<Care> getSingleCare(@PathVariable String careId) {
		 Care care = careService.getCare(careId);
	        return ResponseEntity.ok(care);
	 }
	 
	 
	 @GetMapping("/all")
	    public ResponseEntity<List<Care>> getAllCare() {
	        List<Care> allCare = careService.getAllCare();
	        return ResponseEntity.ok(allCare);
	    }
	 
	 }
	
	


package com.lcwd.care.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.care.service.entities.Care;
import com.lcwd.care.service.exceptions.ResourceNotFoundException;
import com.lcwd.care.service.repositories.CareRepository;
import com.lcwd.care.service.services.CareService;


@Service
public class CareServiceImpl implements CareService {
	
	@Autowired
	private CareRepository careRepository;

	@Override
	public Care saveCare(Care care) {
		
	String randomCareId = UUID.randomUUID().toString();	
	care.setCareId(randomCareId);	             									// TODO Auto-generated method stub
		return careRepository.save(care);
	}

	@Override
	public List<Care> getAllCare() {
		// TODO Auto-generated method stub
		return careRepository.findAll();
	}

	@Override
	public Care getCare(String careId) {
		// TODO Auto-generated method stub
		 return careRepository.findById(careId).orElseThrow(() -> new ResourceNotFoundException("Caregiver with given id is not found on server !! : " + careId));
	}

}

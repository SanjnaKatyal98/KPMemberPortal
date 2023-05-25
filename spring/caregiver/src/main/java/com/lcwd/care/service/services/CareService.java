package com.lcwd.care.service.services;

import java.util.List;

import com.lcwd.care.service.entities.Care;

public interface CareService {

	
	//user operations

    //create
    Care saveCare(Care care);

    //get all user
    List<Care> getAllCare();

    //get single user of given userId

    Care getCare(String careId);
}

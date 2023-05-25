package com.lcwd.care.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.care.service.entities.Care;

public interface CareRepository extends JpaRepository<Care,String> {

}

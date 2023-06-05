package com.kp_memberportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp_memberportal.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	
}

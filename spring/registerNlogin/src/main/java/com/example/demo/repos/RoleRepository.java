package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	//role se related DB operations honge
	//DB mei cheeze save hongi
}
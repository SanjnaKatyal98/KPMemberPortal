package com.example.demo.models;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	//properties
	@Id
	private int roleId;
	private String rname;
		
	//getters and setters
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
		
	//constructors
	public Role(int roleId, String rname) {
		super();
		this.roleId = roleId;
		this.rname = rname;
	}
	public Role() {
		super();
	}
	
	//foreign key in userrole table
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "role")
	private Set<UserRole> userRoles=new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
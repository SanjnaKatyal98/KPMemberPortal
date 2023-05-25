package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	//yeh dono tables [user nd role] ko connect krne ke liye
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userRoleId;
	//kaunse user k kaunsa role mill raha issi se pata lagega
	//user
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	//role
	@ManyToOne
	private Role role;
		
	//getters and setters
	public int getUserRoleId() {
		return userRoleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	//constructors
	public UserRole() {
		super();
			// TODO Auto-generated constructor stub
	}
	public UserRole(int userRoleId, User user, Role role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}
}
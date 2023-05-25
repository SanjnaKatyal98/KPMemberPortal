package com.example.demo.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Table(name="users")
public class User implements UserDetails{ //issko implement kra for login security
	//properties
	@Id //primary key is id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid")
	private int id;
	@Column(length = 25) //column length is 25
	private String firstname;
	@Column(length = 25)
	private String lastname;
	@Column(unique = true) //column is unique,value cant be repeated
	private String username;
	private String password;
	private String address;
	private boolean enabled=true;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	//constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String firstname, String lastname, String username, String password, String address,
			boolean enabled) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.enabled = enabled;
	}
	
	//displaying
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", address=" + address + ", enabled=" + enabled + ", userRoles="
				+ userRoles + "]";
	}
	
	//user has many roles
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "user")
	@JsonIgnore //circular dependancy na create ho
	private Set<UserRole> userRoles=new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	//isske[security] methods ko override krne ka faida yeh hai ki issi class mei sab implementation ho jayegi
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();
		//adding authority;which is imp;userrole ke obj se nikalenge hum
		this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRname()));
		});
		return set;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
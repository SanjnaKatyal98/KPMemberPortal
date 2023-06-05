package com.kp_memberportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kp_memberportal.entities.Role;
import com.kp_memberportal.entities.User;
import com.kp_memberportal.entities.UserRole;
import com.kp_memberportal.helper.UserFoundException;
import com.kp_memberportal.service.UserService;

@SpringBootApplication
public class KpMemberportalApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(KpMemberportalApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
    
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	 try {
		System.out.println("starting code");
		
		User user = new User();
		
		user.setFirstname("Riya");
		user.setLastname("Dutta");
		user.setUsername("riyadutta@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("Riya@2000!"));
		user.setAddress("12/A , A.G.Road");
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1); 
		
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
	 }catch(UserFoundException e) {
		 e.printStackTrace();
	 }
	}

}

package com.example.demo;

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

import com.example.demo.helper.UserFoundException;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.services.UserService;

@SpringBootApplication
public class RegisterNLoginApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;//spring security jb use krenge tb use hoga
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(RegisterNLoginApplication.class, args);
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
		System.out.println("starting code");
		try {
			//user create kia
			User user=new User();
			user.setFirstname("sanjna");
			user.setLastname("katyal");
			user.setUsername("sanj09");
			user.setPassword("shahid28");
			user.setAddress("new delhi");
					
			//role create kia
			Role role=new Role();
			role.setRoleId(1);
			role.setRname("ADMIN");
					
			//role set create kia
			Set<UserRole> userRoleSet=new HashSet<>();
			UserRole userRole=new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			userRoleSet.add(userRole);
					
			User u=userService.createUser(user, userRoleSet);
			System.out.println(u.getUsername());
		}catch (UserFoundException e) {
            e.printStackTrace();
        }
		System.out.println("ending code");
	}
}
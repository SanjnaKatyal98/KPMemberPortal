package com.lcwd.care.service.entities;






import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cares")

public class Care {

	
	
	
	@Id
	@Column(name = "ID")
    private  String careId;
	
	@Column(name ="FASTNAME")
	private String fastname;
	
	@Column(name ="LASTNAME")
	private String lastname;
	
	@Column(name ="NUMBER",length = 12)
	private String number;
	
	
	
}

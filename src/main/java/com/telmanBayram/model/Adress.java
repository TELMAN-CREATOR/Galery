package com.telmanBayram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "adress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adress extends BaseEntity {

	private String city;
	
	private String district;
	
	private String neighboorHood;
	
	private String street;
	
	
	
	
	
}

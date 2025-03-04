package com.telmanBayram.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String tckn;
	
	private Date birthOfDate;
	@OneToOne
	private Adress adress;
	@OneToOne
	private Account account;
}

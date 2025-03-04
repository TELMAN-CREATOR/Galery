package com.telmanBayram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "galerist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Galerist extends BaseEntity {
	
    private String firstName;
	
	private String lastName;
	
	@OneToOne
	private Adress adress;

}

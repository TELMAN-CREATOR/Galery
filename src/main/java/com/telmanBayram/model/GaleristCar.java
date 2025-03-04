package com.telmanBayram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "galerist_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"galerist_id","car_id"},name = "uq_galerist_car")})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GaleristCar extends BaseEntity{

	@ManyToOne
	private Galerist galerist;
	
	@ManyToOne
	private Car car;
}

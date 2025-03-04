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
@Table(name = "saled_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"galerist_id","car_id","customer_id"},name = "uq_galerist_car_customer")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaledCar extends BaseEntity{
	@ManyToOne
	private Galerist galerist;
	@ManyToOne
	private Car car;
	@ManyToOne
	private Customer customer;

}

package com.telmanBayram.dto;

import java.math.BigDecimal;

import com.telmanBayram.enums.CarStatusType;
import com.telmanBayram.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarIU {

	@NotNull
	private String plaka;
	@NotNull
	private String brand;
	@NotNull
	private String model;
	@NotNull
	private Integer productionYear;
	@NotNull
	private BigDecimal price;
	@NotNull
	private CurrencyType currencyType;
	@NotNull
	private BigDecimal damagePrice;
	@NotNull
	private CarStatusType carStatusType;
}

package com.telmanBayram.dto;

import java.math.BigDecimal;

import com.telmanBayram.enums.CarStatusType;
import com.telmanBayram.enums.CurrencyType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCar extends DtoBaseEntity{

	
	private String plaka;
	
	private String brand;
	
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	
	private CurrencyType currencyType;
	
	private BigDecimal damagePrice;
	
	private CarStatusType carStatusType;
}

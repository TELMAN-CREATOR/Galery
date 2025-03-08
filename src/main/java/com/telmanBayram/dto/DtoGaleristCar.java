package com.telmanBayram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGaleristCar extends DtoBaseEntity {
		
	private DtoGalerist galerist;
	
	private DtoCar car;

}

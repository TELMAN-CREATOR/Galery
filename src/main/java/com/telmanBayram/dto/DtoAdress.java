package com.telmanBayram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAdress extends DtoBaseEntity{

    private String city;
	
	private String district;
	
	private String neighboorHood;
	
	private String street;
	
}

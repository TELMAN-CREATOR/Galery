package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoAdressIU;

public interface IRestAdressController {
	
	public RootEntity<DtoAdress> saveAdress(DtoAdressIU dtoAdressIU); 
		
	

}

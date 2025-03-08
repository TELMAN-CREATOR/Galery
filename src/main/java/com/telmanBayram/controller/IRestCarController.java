package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoCar;
import com.telmanBayram.dto.DtoCarIU;

public interface IRestCarController {
	
	public RootEntity<DtoCar>  saveCar(DtoCarIU dtoCarIU);

}

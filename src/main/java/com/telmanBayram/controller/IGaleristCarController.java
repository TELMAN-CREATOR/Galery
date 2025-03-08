package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoGaleristCar;
import com.telmanBayram.dto.DtoGaleristCarIU;

public interface IGaleristCarController {
	
	public RootEntity<DtoGaleristCar>saveGalleristCar(DtoGaleristCarIU dtoGaleristCarIU);

}

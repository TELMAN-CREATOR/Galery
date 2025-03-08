package com.telmanBayram.service;

import com.telmanBayram.dto.DtoGaleristCar;
import com.telmanBayram.dto.DtoGaleristCarIU;

public interface IGaleristCarService {
	
	public DtoGaleristCar saveGaleristCar(DtoGaleristCarIU dtoGaleristCarIU);

}

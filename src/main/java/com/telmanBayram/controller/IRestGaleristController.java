package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoGalerist;
import com.telmanBayram.dto.DtoGaleristIU;

public interface IRestGaleristController {
	
	public RootEntity<DtoGalerist> saveGalerist(DtoGaleristIU dtoGaleristIU);

}

package com.telmanBayram.service;

import com.telmanBayram.dto.DtoGalerist;
import com.telmanBayram.dto.DtoGaleristIU;

public interface IGaleristService {
	
	public DtoGalerist saveGalerist(DtoGaleristIU dtoGaleristIU);

}

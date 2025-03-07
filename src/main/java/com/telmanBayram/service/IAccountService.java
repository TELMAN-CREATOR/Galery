package com.telmanBayram.service;

import com.telmanBayram.dto.DtoAccount;
import com.telmanBayram.dto.DtoAccountIU;

public interface IAccountService {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

}

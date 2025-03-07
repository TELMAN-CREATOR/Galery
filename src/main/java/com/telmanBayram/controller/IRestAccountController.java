package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoAccount;
import com.telmanBayram.dto.DtoAccountIU;

public interface IRestAccountController {
	
	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

}

package com.telmanBayram.controller;

import com.telmanBayram.dto.DtoCustomer;
import com.telmanBayram.dto.DtoCustomerIU;

public interface IRestCustomerController {
	
	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

}

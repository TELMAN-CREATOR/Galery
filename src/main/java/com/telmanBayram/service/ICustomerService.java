package com.telmanBayram.service;

import com.telmanBayram.dto.DtoCustomer;
import com.telmanBayram.dto.DtoCustomerIU;

public interface ICustomerService {
	
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}

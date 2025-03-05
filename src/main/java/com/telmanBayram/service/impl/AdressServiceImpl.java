package com.telmanBayram.service.impl;



import org.springframework.stereotype.Service;

import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.service.IAdressService;
@Service
public class AdressServiceImpl implements IAdressService {

	public void test() {
		throw new BaseException(new ErrorMessage(null,MesagesType.NO_RECOR_EXİST));
	}
}

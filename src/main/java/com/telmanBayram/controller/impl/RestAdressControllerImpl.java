package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.IRestAdressController;
import com.telmanBayram.controller.RestBaseController;
import com.telmanBayram.controller.RootEntity;
import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoAdressIU;
import com.telmanBayram.service.IAdressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/adress")
public class RestAdressControllerImpl extends RestBaseController implements IRestAdressController{

	@Autowired
	private IAdressService adressService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAdress> saveAdress(@Valid @RequestBody DtoAdressIU dtoAdressIU) {
		return ok(adressService.saveAdress(dtoAdressIU));
	}
	
	

}

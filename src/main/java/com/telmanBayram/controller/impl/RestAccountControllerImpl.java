package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.IRestAccountController;
import com.telmanBayram.controller.RestBaseController;
import com.telmanBayram.controller.RootEntity;
import com.telmanBayram.dto.DtoAccount;
import com.telmanBayram.dto.DtoAccountIU;
import com.telmanBayram.service.IAccountService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController{

	@Autowired
	private IAccountService accountService;
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		
		return ok(accountService.saveAccount(dtoAccountIU));
	}
	
	

}

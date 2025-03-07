package com.telmanBayram.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoAccount;
import com.telmanBayram.dto.DtoAccountIU;
import com.telmanBayram.model.Account;
import com.telmanBayram.repository.AccountRepository;
import com.telmanBayram.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount=new DtoAccount();
		Account account=new Account();
		account.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoAccountIU, account);
		Account savedAccount = accountRepository.save(account);
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}


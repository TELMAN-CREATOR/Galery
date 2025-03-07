package com.telmanBayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoAccount;
import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoCustomer;
import com.telmanBayram.dto.DtoCustomerIU;
import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.model.Account;
import com.telmanBayram.model.Adress;
import com.telmanBayram.model.Customer;
import com.telmanBayram.repository.AccountRepository;
import com.telmanBayram.repository.AdressRepository;
import com.telmanBayram.repository.CustomerRepository;
import com.telmanBayram.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
		
		Optional<Adress> optional = adressRepository.findById(dtoCustomerIU.getAdressId());
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST,dtoCustomerIU.getAdressId().toString()));
		}
		
		Optional<Account> optional2 = accountRepository.findById(dtoCustomerIU.getAccountId());
		if (optional2.isEmpty()) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST,dtoCustomerIU.getAccountId().toString()));
			
		}
		
		Customer customer=new Customer();
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		customer.setCreateTime(new Date());
		customer.setAdress(optional.get());
		customer.setAccount(optional2.get());
		
		return customer;
	}
	
	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		
		DtoCustomer dtoCustomer=new DtoCustomer();
		DtoAccount dtoAccount=new DtoAccount();
		DtoAdress dtoAdress=new DtoAdress();
		
		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));
		
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAdress(), dtoAdress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

	
		dtoCustomer.setDtoAccount(dtoAccount);
		dtoCustomer.setDtoAdress(dtoAdress);
		
		
		return dtoCustomer;
	}

}






















package com.telmanBayram.service.impl;


import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.AuthRequest;
import com.telmanBayram.dto.DtoUser;
import com.telmanBayram.model.User;
import com.telmanBayram.repository.UserRepoaitory;
import com.telmanBayram.service.IAuthenticateService;
@Service
public class AuthenticateServiceImpl implements IAuthenticateService{

	@Autowired
	private UserRepoaitory userRepoaitory;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private User createUser(AuthRequest input) {
		User user=new User();
		user.setCreateTime(new Date()); 
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		
		return user;
	}
	
	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser=new DtoUser();
		
		User savedUser = userRepoaitory.save(createUser(input));
		
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}

	
}

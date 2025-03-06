package com.telmanBayram.service;

import com.telmanBayram.dto.AuthRequest;
import com.telmanBayram.dto.AuthResponse;
import com.telmanBayram.dto.DtoUser;

public interface IAuthenticateService {

	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	
}

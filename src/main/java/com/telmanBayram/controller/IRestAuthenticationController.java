package com.telmanBayram.controller;

import com.telmanBayram.dto.AuthRequest;
import com.telmanBayram.dto.AuthResponse;
import com.telmanBayram.dto.DtoUser;
import com.telmanBayram.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
	
	
}

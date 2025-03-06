package com.telmanBayram.service.impl;




import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.AuthRequest;
import com.telmanBayram.dto.AuthResponse;
import com.telmanBayram.dto.DtoUser;
import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.jwt.JwtService;
import com.telmanBayram.model.RefreshToken;
import com.telmanBayram.model.User;
import com.telmanBayram.repository.RefreshTokenRepository;
import com.telmanBayram.repository.UserRepoaitory;
import com.telmanBayram.service.IAuthenticateService;
@Service
public class AuthenticateServiceImpl implements IAuthenticateService{

	@Autowired
	private UserRepoaitory userRepoaitory;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private User createUser(AuthRequest input) {
		User user=new User();
		user.setCreateTime(new Date()); 
		user.setUsername(input.getUsername());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		
		return user;
	}
	
	private RefreshToken creteRefreshToken(User user) {
		 RefreshToken refreshToken=new RefreshToken();
		 
		 refreshToken.setCreateTime(new Date());
		 refreshToken.setExpireDate(new Date(System.currentTimeMillis()+1000*60*60*4));
		 refreshToken.setRefreshToken(UUID.randomUUID().toString());
		 refreshToken.setUser(user);
		 
		 return refreshToken;
		 
	}
	
	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser=new DtoUser();
		
		User savedUser = userRepoaitory.save(createUser(input));
		
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}

	@Override
	public AuthResponse authenticate(AuthRequest input) {
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken=
					new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
			
			authenticationProvider.authenticate(authenticationToken);
			
			Optional<User> optional = userRepoaitory.findByUsername(input.getUsername());
			
			String accesToken = jwtService.generateToken(optional.get());
			
			RefreshToken refreshToken = creteRefreshToken(optional.get());
			
			RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);
			
			return new AuthResponse(accesToken, savedRefreshToken.getRefreshToken());
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MesagesType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
		}

	}

	
}

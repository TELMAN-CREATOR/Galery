package com.telmanBayram.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.model.User;
import com.telmanBayram.repository.UserRepoaitory;

@Configuration
public class AppConfig {

	@Autowired
	private UserRepoaitory userRepoaitory;
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<User> optional = userRepoaitory.findByUsername(username);
				if (optional.isEmpty()) {
					throw new BaseException(new ErrorMessage(MesagesType.USERNAME_NOT_FOUND, username));
				}
				return optional.get();
			}
		};
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
	
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
}

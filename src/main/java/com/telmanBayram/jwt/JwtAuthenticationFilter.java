package com.telmanBayram.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		
		if (header==null) {
			filterChain.doFilter(request, response);
			return;
		}
		String token;
		String username;
		
		token=header.substring(7);
		
		try {
			
			username = jwtService.getUsernameByToken(token);
			
			if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (userDetails!=null&& jwtService.isTokenValid(token)) {
					UsernamePasswordAuthenticationToken authenticationToken=
							new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
					
					authenticationToken.setDetails(userDetails);
					
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					
				}
				
			}	
			
			
		} catch (ExpiredJwtException e) {
			throw new BaseException(new ErrorMessage(MesagesType.TOKEN_IS_EXPIRED, e.getMessage()));
		}
		catch (Exception e) {
			throw new BaseException(new ErrorMessage(MesagesType.GENERAL_EXCEPTİON, e.getMessage()));
		}
		filterChain.doFilter(request, response);
		
	}

}

package com.telmanBayram.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_NULL) // not returns null values.
public class RootEntity <T>{
	
	private Integer status;
	
	private T payload;
	
	private String errorMessage;
	
	
	public static <T> RootEntity<T> ok(T payload){
		RootEntity<T> rootEntity=new RootEntity<>();
		rootEntity.setStatus(200);
		rootEntity.setErrorMessage(null);
		rootEntity.setPayload(payload);
		
		return rootEntity;
	}
	
	public static<T>RootEntity<T> error(String errorMessage) {
		
		RootEntity<T> rootEntity=new RootEntity<>();
		
		rootEntity.setErrorMessage(errorMessage);
		rootEntity.setStatus(500);
		rootEntity.setPayload(null);
		
		return rootEntity;
	}

}

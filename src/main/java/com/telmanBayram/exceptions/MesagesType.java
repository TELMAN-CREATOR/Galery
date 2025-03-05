package com.telmanBayram.exceptions;

import lombok.Getter;

@Getter
public enum MesagesType {

	NO_RECOR_EXİST("1004","KAYIT BULUNAMADI"),
	TOKEN_IS_EXPIRED("1005","Tokenin süresi dolmuş"),
	GENERAL_EXCEPTİON("9999","GENEL BİR HATA OLUŞTU");

	private String message;
	
	private String code;
	
	
	
	
	MesagesType(String code, String message) {
		this.code=code;
	    this.message=message;
	}
	
}

package com.telmanBayram.exceptions;

import lombok.Getter;

@Getter
public enum MesagesType {

	NO_RECOR_EXİST("1004","KAYIT BULUNAMADI"),
	GENERAL_EXCEPTİON("9999","GENEL BİR HATA OLUŞTU");

	
	private String code;
	
	private String message;
	
	
	MesagesType(String code, String message) {
		this.code=code;
	    this.message=message;
	}
	
}

package com.telmanBayram.controller;

import com.telmanBayram.dto.CurrencyResponse;

public interface ICurrencyResponseController {
	
	public CurrencyResponse getCurrency(String currency, String responseType);
	

}

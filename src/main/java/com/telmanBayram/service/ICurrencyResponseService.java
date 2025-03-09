package com.telmanBayram.service;

import com.telmanBayram.dto.CurrencyResponse;

public interface ICurrencyResponseService {

	

	public CurrencyResponse getCurrency(String currency, String responseType);
}

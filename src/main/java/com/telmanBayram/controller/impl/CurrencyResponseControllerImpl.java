package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.ICurrencyResponseController;
import com.telmanBayram.dto.CurrencyResponse;
import com.telmanBayram.service.ICurrencyResponseService;

@RestController
@RequestMapping("/currency")
public class CurrencyResponseControllerImpl implements ICurrencyResponseController{

	@Autowired
	private ICurrencyResponseService currencyResponseService;
	
	@GetMapping("/{currency}/{responseType}")
	@Override
	public CurrencyResponse getCurrency(@PathVariable(value = "currency") String currency, @PathVariable(value = "responseType") String responseType) {
		return currencyResponseService.getCurrency(currency, responseType);
		
	}

}

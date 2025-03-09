package com.telmanBayram.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telmanBayram.dto.CurrencyResponse;
import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.service.ICurrencyResponseService;

@Service
public class CurrencyResponseServiceImpl implements ICurrencyResponseService{

	final private String apiUrl="https://v6.exchangerate-api.com/v6/e046fe4c95d65f096aa3c0d4/latest/";

	@Override
	public CurrencyResponse getCurrency(String currency, String responseType) {
		
		CurrencyResponse currencyResponse=new CurrencyResponse();
		
		RestTemplate restTemplate =new RestTemplate();
		String forObject = restTemplate.getForObject(apiUrl+currency.toUpperCase(), String.class);
		
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			JsonNode node = objectMapper.readTree(forObject);
			
			JsonNode path = node.path("conversion_rates");  
			
			if (path.get(responseType.toUpperCase())==null) {
				throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST,responseType.toUpperCase()));
			}
			
			currencyResponse.setCurrency(path.get(responseType.toUpperCase()).asDouble());
			
			
			
		} catch (JsonMappingException e) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST,responseType.toUpperCase()));
		} catch (JsonProcessingException e) {
			throw new BaseException(new ErrorMessage(MesagesType.GENERAL_EXCEPTİON,responseType.toUpperCase()));
		}
		
		return currencyResponse;
	}

	

	
	
}

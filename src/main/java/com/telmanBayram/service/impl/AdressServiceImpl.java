package com.telmanBayram.service.impl;



import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoAdressIU;
import com.telmanBayram.model.Adress;
import com.telmanBayram.repository.AdressRepository;
import com.telmanBayram.service.IAdressService;
@Service
public class AdressServiceImpl implements IAdressService {
	
	@Autowired
	private AdressRepository adressRepository;

	private Adress createAdress(DtoAdressIU dtoAdressIU) {
		Adress adress=new Adress();
		adress.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAdressIU, adress);
		return adress;
	}
	
	@Override
	public DtoAdress saveAdress(DtoAdressIU dtoAdressIU) {
		DtoAdress dtoAdress=new DtoAdress();
		
		Adress savedAdress = adressRepository.save(createAdress(dtoAdressIU));
		BeanUtils.copyProperties(savedAdress, dtoAdress);
		
		return dtoAdress;
	}

	
}

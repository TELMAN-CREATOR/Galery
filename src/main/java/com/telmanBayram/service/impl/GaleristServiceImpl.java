package com.telmanBayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoGalerist;
import com.telmanBayram.dto.DtoGaleristIU;
import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.model.Adress;
import com.telmanBayram.model.Galerist;
import com.telmanBayram.repository.AdressRepository;
import com.telmanBayram.repository.GaleristRepository;
import com.telmanBayram.service.IGaleristService;

@Service
public class GaleristServiceImpl implements IGaleristService{

	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private GaleristRepository galeristRepository;
	
	private Galerist createGalerist(DtoGaleristIU dtoGaleristIU) {
		Galerist galerist=new Galerist();
		Optional<Adress> optional = adressRepository.findById(dtoGaleristIU.getAdressId());
		
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST, dtoGaleristIU.getAdressId().toString()));
		}
		
		BeanUtils.copyProperties(dtoGaleristIU, galerist);
		galerist.setAdress(optional.get());
		galerist.setCreateTime(new Date());
		
		return galerist;
	}
	
	@Override
	public DtoGalerist saveGalerist(DtoGaleristIU dtoGaleristIU) {
		DtoGalerist dtoGalerist=new DtoGalerist();
		DtoAdress dtoAdress=new DtoAdress();
		
		
		Galerist savedGalerist = galeristRepository.save(createGalerist(dtoGaleristIU));
		
		BeanUtils.copyProperties(savedGalerist, dtoGalerist);
		BeanUtils.copyProperties(savedGalerist.getAdress(), dtoAdress);
		dtoGalerist.setDtoAdress(dtoAdress);
		
		return dtoGalerist;
	}

}
























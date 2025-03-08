package com.telmanBayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoAdress;
import com.telmanBayram.dto.DtoCar;
import com.telmanBayram.dto.DtoGalerist;
import com.telmanBayram.dto.DtoGaleristCar;
import com.telmanBayram.dto.DtoGaleristCarIU;
import com.telmanBayram.exceptions.BaseException;
import com.telmanBayram.exceptions.ErrorMessage;
import com.telmanBayram.exceptions.MesagesType;
import com.telmanBayram.model.Car;
import com.telmanBayram.model.Galerist;
import com.telmanBayram.model.GaleristCar;
import com.telmanBayram.repository.CarRepository;
import com.telmanBayram.repository.GaleristCarRepository;
import com.telmanBayram.repository.GaleristRepository;
import com.telmanBayram.service.IGaleristCarService;

@Service
public class GaleristCarServiceImpl implements IGaleristCarService{

	@Autowired
	private GaleristCarRepository galeristCarRepository;
	
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired 
	private GaleristRepository galeristRepository;
	
	
	private GaleristCar createGaleristCar(DtoGaleristCarIU dtoGaleristCarIU) {
		GaleristCar galeristCar =new GaleristCar();
		
		Optional<Car> carOptional = carRepository.findById(dtoGaleristCarIU.getCarId());
		
		if (carOptional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST, dtoGaleristCarIU.getCarId().toString()));
		}
		
		Optional<Galerist> galeristOptional = galeristRepository.findById(dtoGaleristCarIU.getGaleristId());
		if (galeristOptional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MesagesType.NO_RECOR_EXİST, dtoGaleristCarIU.getGaleristId().toString() ));
		}
		galeristCar.setCreateTime(new Date());
		galeristCar.setCar(carOptional.get());
		galeristCar.setGalerist(galeristOptional.get());
		
		return galeristCar;
	}
	
	
	
	@Override
	public DtoGaleristCar saveGaleristCar(DtoGaleristCarIU dtoGaleristCarIU) {
		   DtoGaleristCar dtoGaleristCar=new DtoGaleristCar();
		   DtoGalerist dtoGalerist=new DtoGalerist();
		   DtoAdress dtoAdress=new DtoAdress();
		   DtoCar dtoCar=new DtoCar();
		
		
		   GaleristCar savedGaleristCar = galeristCarRepository.save(createGaleristCar(dtoGaleristCarIU));
		
		
		   BeanUtils.copyProperties(savedGaleristCar, dtoGaleristCar);
		   BeanUtils.copyProperties(savedGaleristCar.getGalerist(), dtoGalerist);
		   BeanUtils.copyProperties(savedGaleristCar.getCar(), dtoCar);
		   BeanUtils.copyProperties(savedGaleristCar.getGalerist().getAdress(), dtoAdress);
		
		   dtoGaleristCar.setCar(dtoCar);
		   dtoGalerist.setDtoAdress(dtoAdress);
		   dtoGaleristCar.setGalerist(dtoGalerist);
		
		
		   return dtoGaleristCar;
		   
	}

}

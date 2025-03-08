package com.telmanBayram.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telmanBayram.dto.DtoCar;
import com.telmanBayram.dto.DtoCarIU;
import com.telmanBayram.model.Car;
import com.telmanBayram.repository.CarRepository;
import com.telmanBayram.service.ICarSeervice;

@Service
public class CarService implements ICarSeervice {

	@Autowired
	private CarRepository carRepository;
	
	private Car createCar(DtoCarIU dtoCarIU) {
		Car car=new Car();
		car.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}
	
	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {

		DtoCar dtoCar=new DtoCar();
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
	}

}

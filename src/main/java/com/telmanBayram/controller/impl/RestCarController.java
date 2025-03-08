package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.IRestCarController;
import com.telmanBayram.controller.RestBaseController;
import com.telmanBayram.controller.RootEntity;
import com.telmanBayram.dto.DtoCar;
import com.telmanBayram.dto.DtoCarIU;
import com.telmanBayram.service.ICarSeervice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car")
public class RestCarController extends RestBaseController implements IRestCarController {

	@Autowired
	private ICarSeervice carSeervice;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
		
		return ok(carSeervice.saveCar(dtoCarIU));
	}

}

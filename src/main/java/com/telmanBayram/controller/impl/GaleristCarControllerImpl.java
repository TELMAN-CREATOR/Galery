package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.IGaleristCarController;
import com.telmanBayram.controller.RestBaseController;
import com.telmanBayram.controller.RootEntity;
import com.telmanBayram.dto.DtoGaleristCar;
import com.telmanBayram.dto.DtoGaleristCarIU;
import com.telmanBayram.service.IGaleristCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/galerist-car")
public class GaleristCarControllerImpl extends RestBaseController implements IGaleristCarController{

	@Autowired
	private IGaleristCarService galeristCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGaleristCar> saveGalleristCar(@Valid @RequestBody DtoGaleristCarIU dtoGaleristCarIU) {
		
		return ok(galeristCarService.saveGaleristCar(dtoGaleristCarIU));
	}

}

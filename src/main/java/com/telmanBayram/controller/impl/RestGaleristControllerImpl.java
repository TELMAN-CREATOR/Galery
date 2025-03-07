package com.telmanBayram.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telmanBayram.controller.IRestGaleristController;
import com.telmanBayram.controller.RestBaseController;
import com.telmanBayram.controller.RootEntity;
import com.telmanBayram.dto.DtoGalerist;
import com.telmanBayram.dto.DtoGaleristIU;
import com.telmanBayram.service.IGaleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/galerist")
public class RestGaleristControllerImpl extends RestBaseController implements IRestGaleristController{

	@Autowired
	private IGaleristService galeristService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGalerist> saveGalerist(@Valid @RequestBody DtoGaleristIU dtoGaleristIU) {
		
		return ok(galeristService.saveGalerist(dtoGaleristIU));
	}

}

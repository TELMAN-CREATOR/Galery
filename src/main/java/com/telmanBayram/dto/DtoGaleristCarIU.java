package com.telmanBayram.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGaleristCarIU {

	@NotNull
	private Long galeristId;
	

	@NotNull
	private Long carId; 
}

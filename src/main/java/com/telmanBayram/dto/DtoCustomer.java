package com.telmanBayram.dto;





import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomer extends DtoBaseEntity{

	
	private String firstName;
	
	private String lastName;
	
	private String tckn;
	
	private Date birthOfDate;
	
	private DtoAdress dtoAdress;
	
	private DtoAccount dtoAccount;
	
}

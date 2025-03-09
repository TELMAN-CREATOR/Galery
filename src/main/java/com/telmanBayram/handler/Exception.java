package com.telmanBayram.handler;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exception <E>{
	
	private String path;
	
	private Date createTime;
	
	private String hostName;
	
	private E message;

}

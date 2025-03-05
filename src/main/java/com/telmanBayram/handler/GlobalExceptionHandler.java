package com.telmanBayram.handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.telmanBayram.exceptions.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError<?>> handleBaseException(BaseException exception,WebRequest webRequest) {
	  return	ResponseEntity.badRequest().body(cretaeApiError(exception.getMessage(), webRequest));
		
		
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,WebRequest request) {
		Map<String, List<String>> map=new HashMap<>();
		for (ObjectError objectError : exception.getBindingResult().getAllErrors()) {
			String fieldname=((FieldError)objectError).getField();
			
			if (map.containsKey(fieldname)) {
				
				map.put(fieldname, addStringToList(map.get(fieldname), objectError.getDefaultMessage()));
			}else {
				map.put(fieldname,addStringToList(new ArrayList<>(), objectError.getDefaultMessage()) );
			}
			
		}
		
		return ResponseEntity.badRequest().body(cretaeApiError(map, request));
	}
	
	
	private List<String> addStringToList(List<String>liste , String message) {
		liste.add(message);
		return liste;
	}
	
	
	
	public String getHostName(){
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	
	public<E> ApiError<E> cretaeApiError(E message,WebRequest webRequest) {
		
		ApiError<E>apiError=new ApiError<>();
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		Exception<E>exception=new Exception<>();
		exception.setCreateTime(new Date(0));
		exception.setMessage(message);
		exception.setPath(webRequest.getDescription(false));
		exception.setHostName(getHostName());
		
		apiError.setException(exception);
		
		return apiError;
		
	}
	
	
	
	
}

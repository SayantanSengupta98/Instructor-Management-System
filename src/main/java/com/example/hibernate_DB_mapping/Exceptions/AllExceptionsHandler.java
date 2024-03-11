package com.example.hibernate_DB_mapping.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hibernate_DB_mapping.Entity.EntityNotFound;

@ControllerAdvice
public class AllExceptionsHandler {
	
	@ExceptionHandler
	public ResponseEntity<EntityNotFound> handleAllExceptions(Exception ex){
		
		EntityNotFound exc = new EntityNotFound();
		exc.setError(ex.getMessage());
		exc.setStatus(HttpStatus.NOT_FOUND.value());
		exc.setTimeStamp(String.valueOf(new java.util.Date()));
		
		return new ResponseEntity<EntityNotFound>(exc, HttpStatus.NOT_FOUND);
	
	
	}	

}

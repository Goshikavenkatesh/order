package com.orderInventory.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orderInventory.entity.ErrorResponse;

@ControllerAdvice
public class ProductsExceptionHandler {
	
	@ExceptionHandler(ProductsNotFoundException.class)
	
	public ResponseEntity<ErrorResponse> handleException(ProductsNotFoundException exception) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); 
		error.setMessage(exception.getMessage()); 
		error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}

}

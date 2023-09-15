package com.dakr.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dakr.entity.Employee;

@ControllerAdvice

public class MyControllerAdvice extends ResponseEntityExceptionHandler {
@ExceptionHandler(NoSuchElementException.class)
 public ResponseEntity<String> handleEmptyInput(NoSuchElementException dataNotFoundException){
 return new ResponseEntity<String>(" please Enter valid Id ",HttpStatus.NOT_FOUND);
	
}
@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
	 return new ResponseEntity<Object>("please change Your HttpMethod type",HttpStatus.NOT_FOUND);
	
	}

 @ExceptionHandler(EmptyInputException.class) 
 public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyIntputException ){
	 return new  ResponseEntity<String>("Please Enter valid name ",HttpStatus.BAD_REQUEST);
 }
}

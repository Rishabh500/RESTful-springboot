package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest req) {
//		ExceptionResponse exp = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));
//		return new ResponseEntity(exp, HttpStatus.BAD_REQUEST);
//
//	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException e, WebRequest req) {
		ExceptionResponse exp = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity(exp, HttpStatus.NOT_FOUND);

	}
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exp = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().getAllErrors().toString());
		return new ResponseEntity(exp,HttpStatus.BAD_REQUEST);
	}
	
}

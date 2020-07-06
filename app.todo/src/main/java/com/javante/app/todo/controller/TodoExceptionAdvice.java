package com.javante.app.todo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javante.app.todo.model.ErrorDetail;
import com.javante.app.todo.model.TodoException;

@ControllerAdvice
public class TodoExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TodoException.class)
	protected ResponseEntity<Object> handleExceptionInternal(TodoException ex, 
			WebRequest request) {
		
		ErrorDetail error = new ErrorDetail(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
    
}

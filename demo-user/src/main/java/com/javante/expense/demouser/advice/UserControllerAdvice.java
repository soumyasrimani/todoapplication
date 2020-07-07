package com.javante.expense.demouser.advice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javante.expense.demouser.exception.ErrorDetail;
import com.javante.expense.demouser.exception.UserException;

@RestControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler{


	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorDetail err = new ErrorDetail(new Date(), ex.getMessage(), status.toString(),
				request.getDescription(false));

		
		return super.handleExceptionInternal(ex, err, headers, status, request);
	}

	
	@ExceptionHandler(UserException.class)
	protected ResponseEntity<ErrorDetail> handleUserException(UserException ex,  WebRequest request) {
		
		ErrorDetail err = new ErrorDetail(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.toString(),request.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}

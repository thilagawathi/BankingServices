/**
 * {@link GlobalException}
 */
package com.bank.service.globalexception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.service.customException.EmptyInputException;
import com.bank.service.customException.ResourceNotFoundException;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

/**
 * 
 * @param empty
 * @return EmptyInputException
 */
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<EmptyInputException> handleEmptyInput(EmptyInputException empty){
		EmptyInputException ei=new EmptyInputException(empty.getErrorCode(),empty.getErrorMessage());
		return new ResponseEntity<EmptyInputException>(ei,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 
	 * @param elementException
	 * @return NoSuchElementException
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException elementException){
		
		return new ResponseEntity<String>("Given id is not present in the DB",HttpStatus.NOT_FOUND);
	}
	

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		return new ResponseEntity<Object>("Please change http method type",HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * 
	 * @param re
	 * @return ResourceNotFoundException
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResourceNotFoundException> handleResourceNotFoundException(ResourceNotFoundException re){
		ResourceNotFoundException rne=new ResourceNotFoundException(re.getErrorCode(),re.getErrorMessage());
		return new ResponseEntity<ResourceNotFoundException>(rne,HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param np
	 * @return String
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException np){
		
		return new ResponseEntity<String>("please check input is null",HttpStatus.NOT_FOUND);
	}
	
}

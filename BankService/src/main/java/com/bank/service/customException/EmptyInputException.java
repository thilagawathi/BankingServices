/**
 * {@link EmptyInputException}
 */
package com.bank.service.customException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	
	
}

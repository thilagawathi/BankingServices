/**
 * {@link EmptyInputException}
 */
package com.bank.service.customException;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	
	
}

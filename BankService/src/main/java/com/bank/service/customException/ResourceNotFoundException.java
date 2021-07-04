/**
 * {@link ResourceNotFoundException}
 */
package com.bank.service.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
}

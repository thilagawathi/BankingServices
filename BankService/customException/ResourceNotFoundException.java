/**
 * {@link ResourceNotFoundException}
 */
package com.bank.service.customException;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
}

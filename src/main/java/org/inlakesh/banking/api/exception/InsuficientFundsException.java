package org.inlakesh.banking.api.exception;

public class InsuficientFundsException extends RuntimeException{

	private static final long serialVersionUID = 2694457922445910113L;

	public InsuficientFundsException(String message) {
		super(message);
	}
	
	
}

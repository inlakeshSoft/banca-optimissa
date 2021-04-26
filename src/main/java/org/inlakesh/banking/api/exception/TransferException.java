package org.inlakesh.banking.api.exception;

public class TransferException extends RuntimeException {

	private static final long serialVersionUID = 7312628191802729281L;

	public TransferException(String message) {
		super(message);
	}

}

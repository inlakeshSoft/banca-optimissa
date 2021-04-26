package org.inlakesh.banking.api.exception;

/**
 * Definicio de excepcion para una cuenta no encontrada
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */
public class NoAccountFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5611325588924108162L;
	
	public NoAccountFoundException() {
		super("No se encontró la cuenta requerida");
	}
	
}

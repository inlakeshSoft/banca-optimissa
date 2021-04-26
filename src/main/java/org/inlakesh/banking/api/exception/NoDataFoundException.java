package org.inlakesh.banking.api.exception;

/**
 * Definicio de excepcion para informacion no encontrada
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = -7751127422969980075L;
	
	public static final String NO_DATA_FOUND_MESSAGE = "No se encontraron registros";
	
	public NoDataFoundException(){
		super(NO_DATA_FOUND_MESSAGE);
	}	
	
}

package org.inlakesh.banking.api.exception.handler;

import java.util.List;

import org.inlakesh.banking.api.exception.NoAccountFoundException;
import org.inlakesh.banking.api.exception.NoDataFoundException;
import org.inlakesh.banking.api.exception.TransferException;
import org.inlakesh.banking.api.message.ErrorMessage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

/**
 * Controlador para la captura de excepciones y contruccion de mensajes de
 * retorno
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class BanckingExceptionHandler {

	/**
	 * 
	 * @param endfe
	 * @return
	 */
	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(NoDataFoundException endfe) {
		log.error("Error: ", endfe.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(endfe.getMessage(), HttpStatus.OK.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception e) {
		log.error("Error: " + e.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(
				"Ocurrió un error inesperado, por favor contacte a su administrador",
				HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 
	 * @param nafe
	 * @return
	 */
	@ExceptionHandler(value = NoAccountFoundException.class)
	public ResponseEntity<Object> handleException(NoAccountFoundException nafe) {
		log.error("Error: ", nafe.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(nafe.getMessage(), HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}


	/**
	 * 
	 * @param ife
	 * @return
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleException(HttpMessageNotReadableException ife) {
		log.error("Error: ", ife.getMessage());
		ErrorMessage errorMessage = new ErrorMessage("Bad request exception", HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 
	 * @param te
	 * @return
	 */
	@ExceptionHandler(value = TransferException.class)
	public ResponseEntity<Object> handleException(TransferException te) {
		log.error("Error: ", te.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(te.getMessage(), HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param manve
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException manve) {
		log.error("Error: ", manve.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(getMessage(manve), HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * Get message from the fieldError
	 * 
	 * @param e
	 * @return
	 */
	private String getMessage(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		FieldError fieldError = fieldErrors.stream().findFirst().get();

		return fieldError.getDefaultMessage();
	}

}

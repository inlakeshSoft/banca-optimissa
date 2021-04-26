package org.inlakesh.banking.api.controller;

import javax.validation.Valid;

import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.request.TransactionRequest;
import org.inlakesh.banking.api.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Controlador con los end-points para las Transferencias
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@RestController
@RequestMapping("/transfers")
public class TransferController {

	@Autowired
	private TransferService transferService;

	/**
	 * End-point para realizar una transaccion
	 * 
	 * @param transactionDto
	 * @return Mensaje que indica el exito de la transferencia
	 */
	@PostMapping
	@ApiOperation("Allows money transfers between accounts")
	public ResponseEntity<String> makeTransfer(@Valid @RequestBody(required = true) TransactionRequest transactionRequest) {
		TransactionDTO transaction = new TransactionDTO(transactionRequest.getFromAccount(), transactionRequest.getToAccount(),
				transactionRequest.getAmount(), null);
		this.transferService.makeTransfer(transaction);
		return ResponseEntity.ok("Transferencia exitosa.");
	}

}

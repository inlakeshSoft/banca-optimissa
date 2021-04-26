package org.inlakesh.banking.api.controller;

import java.util.List;

import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.response.TransactionResponse;
import org.inlakesh.banking.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Controlador con los end-points para las conslutas de
 * historicos de Transacciones
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	/**
	 * End-point para obtener todas las transacciones de una cuenta especifica
	 * 
	 * @param account
	 * @return
	 */
	@GetMapping("/{account}/findAllByAccount")
	@ApiOperation("Get all transactions from a specific account")
	public ResponseEntity<TransactionResponse> findAllByAccount(@PathVariable("account") String account) {
		List<TransactionDTO> transactions = this.transactionService.findByFromAccountOrToAccount(account);
		return ResponseEntity.ok(new TransactionResponse(transactions));
	}

	/**
	 * End-point para obtener todas las transacciones recibidas en una cuenta
	 * especifica
	 * 
	 * @param account
	 * @return
	 */
	@GetMapping("/{account}/findAllByAccountTo")
	@ApiOperation("Get all transactions received on a specific account")
	public ResponseEntity<TransactionResponse> findAllByAccountTo(@PathVariable("account") String account) {
		List<TransactionDTO> transactions = this.transactionService.findByToAccount(account);
		return ResponseEntity.ok(new TransactionResponse(transactions));
	}

	/**
	 * End-point para obtener todas las transacciones enviadas por una cuenta
	 * especifica
	 * 
	 * @param account
	 * @return
	 */
	@GetMapping("/{account}/findAllByAccountFrom")
	@ApiOperation("Get all transactions sent by an account")
	public ResponseEntity<TransactionResponse> findAllByAccountFrom(@PathVariable("account") String account) {
		List<TransactionDTO> transactions = this.transactionService.findByFromAccount(account);
		return ResponseEntity.ok(new TransactionResponse(transactions));
	}

}

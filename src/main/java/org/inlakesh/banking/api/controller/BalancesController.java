package org.inlakesh.banking.api.controller;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.response.BalanceResponse;
import org.inlakesh.banking.api.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Controlador de end-points para los Balances
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@RestController
@RequestMapping("/balances")
public class BalancesController {
	
	@Autowired
	private BalanceService balanceService;

	@GetMapping("/{account}/findBalanceByAccount")
	@ApiOperation("Get actual balance of an specifict account")
	public ResponseEntity<BalanceResponse> findBalanceByAccount(@PathVariable("account") String account) {
		AccountDTO balance = this.balanceService.fidByAccount(account);
		return ResponseEntity.ok(new BalanceResponse(balance));
	}

}

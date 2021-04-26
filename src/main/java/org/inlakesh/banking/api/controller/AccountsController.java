package org.inlakesh.banking.api.controller;

import java.util.List;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.response.AccountsResponse;
import org.inlakesh.banking.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Controlador de los end-points para las Cuentas
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@RestController
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private AccountService accountService;

	/**
	 * End-point para obtener el listado de cuentas existentes en el sistema
	 * 
	 * @return Lista de cuentas
	 */
	@GetMapping()
	@ApiOperation(value = "Returns a list of all exiting accounts in system", response = AccountDTO.class, responseContainer = "List")
	public ResponseEntity<AccountsResponse> getAccountList() {
		List<AccountDTO> accounts = this.accountService.findAll();
		return ResponseEntity.ok(new AccountsResponse(accounts));
	}

}

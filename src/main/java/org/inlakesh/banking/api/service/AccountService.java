package org.inlakesh.banking.api.service;

import java.math.BigDecimal;
import java.util.List;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.exception.NoDataFoundException;

/**
 * Interfaz con las definiciones de los metodos necesarios para atender el
 * negocio de las Cuentas
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

public interface AccountService {
	
	List<AccountDTO> findAll();
	
	AccountDTO findByAccount(String account) throws NoDataFoundException;

	void updateAccount(String account, BigDecimal balance) throws NoDataFoundException;
}

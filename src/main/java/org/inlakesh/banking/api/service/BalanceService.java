package org.inlakesh.banking.api.service;

import org.inlakesh.banking.api.dto.AccountDTO;

/**
 * Interfaz con los metodos necesarios para la consulta de datos de Balances
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 * 
 */
public interface BalanceService {

	AccountDTO fidByAccount(String account);

}

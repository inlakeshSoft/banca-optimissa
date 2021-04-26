package org.inlakesh.banking.api.service.impl;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.exception.NoDataFoundException;
import org.inlakesh.banking.api.service.AccountService;
import org.inlakesh.banking.api.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implentacion de la interfaz BalanceService
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */
@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private AccountService accountService;

	/**
	 * 
	 * @return
	 * @throws NoDataFoundException
	 */
	@Override
	public AccountDTO fidByAccount(String account) {
		return this.accountService.findByAccount(account);
	}

}

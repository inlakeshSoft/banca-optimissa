package org.inlakesh.banking.api.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.entity.Account;
import org.inlakesh.banking.api.exception.NoAccountFoundException;
import org.inlakesh.banking.api.exception.NoDataFoundException;
import org.inlakesh.banking.api.mapper.AccountMapper;
import org.inlakesh.banking.api.reporitory.AccountRepository;
import org.inlakesh.banking.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion de interfaz de los metodos definidos en AccountService
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 * @see AccountService
 *
 */

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	/**
	 * 
	 * @return
	 * @throws NoDataFoundException
	 */
	@Override
	public List<AccountDTO> findAll() {
		List<Account> accounts = this.accountRepository.findAll();
		if (accounts.isEmpty())
			throw new NoDataFoundException();
		return AccountMapper.INSTANCE.toDTO(accounts);
	}

	/**
	 * 
	 * @return
	 * @throws NoDataFoundException
	 */
	@Override
	public AccountDTO findByAccount(String account) throws NoAccountFoundException {
		Account result = this.accountRepository.findByAccount(account).orElseThrow(() -> new NoAccountFoundException());
		return AccountMapper.INSTANCE.toDTO(result);
	}

	/**
	 * 
	 * @return
	 * @throws NoDataFoundException
	 */
	@Override
	public void updateAccount(String account, BigDecimal newBalance) throws NoDataFoundException {
		Account toUpdate = this.accountRepository.findByAccount(account).orElseThrow(() -> new NoDataFoundException());
		toUpdate.setBalance(newBalance);
		this.accountRepository.save(toUpdate);
	}

}

package org.inlakesh.banking.api.service.impl;

import java.util.List;

import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.entity.Transaction;
import org.inlakesh.banking.api.exception.NoDataFoundException;
import org.inlakesh.banking.api.mapper.TransactionMapper;
import org.inlakesh.banking.api.reporitory.TransactionRepository;
import org.inlakesh.banking.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interfaz con las implementacionde de los metodos definidos en AccountService
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 * @see TransactionService
 *
 */

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void saveTransaction(Transaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Override
	public List<TransactionDTO> findByFromAccountOrToAccount(String account) {
		List<Transaction> transactions = this.transactionRepository.findByFromAccountOrToAccount(account, account);
		if (transactions.isEmpty())
			throw new NoDataFoundException();
		return TransactionMapper.INSTANCE.toDTO(transactions);
	}

	@Override
	public List<TransactionDTO> findByFromAccount(String account) {
		List<Transaction> transactions = this.transactionRepository.findByFromAccount(account);
		if (transactions.isEmpty())
			throw new NoDataFoundException();
		return TransactionMapper.INSTANCE.toDTO(transactions);
	}

	@Override
	public List<TransactionDTO> findByToAccount(String account) {
		List<Transaction> transactions = this.transactionRepository.findByToAccount(account);
		if (transactions.isEmpty())
			throw new NoDataFoundException();
		return TransactionMapper.INSTANCE.toDTO(transactions);
	}

}

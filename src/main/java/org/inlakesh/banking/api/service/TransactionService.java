package org.inlakesh.banking.api.service;

import java.util.List;

import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.entity.Transaction;

public interface TransactionService {
	
	void saveTransaction(Transaction transaction);

	List<TransactionDTO> findByFromAccountOrToAccount(String account);

	List<TransactionDTO> findByFromAccount(String account);

	List<TransactionDTO> findByToAccount(String account);
	
}

package org.inlakesh.banking.api.service;

import org.inlakesh.banking.api.dto.TransactionDTO;

public interface TransferService {

	void makeTransfer(TransactionDTO transactionDto);
}

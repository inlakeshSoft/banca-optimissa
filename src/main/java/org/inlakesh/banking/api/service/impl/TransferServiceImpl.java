package org.inlakesh.banking.api.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.inlakesh.banking.api.bussines.TransferBussines;
import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.entity.Transaction;
import org.inlakesh.banking.api.exception.InsuficientFundsException;
import org.inlakesh.banking.api.exception.NoDataFoundException;
import org.inlakesh.banking.api.exception.TransferException;
import org.inlakesh.banking.api.mapper.TransactionMapper;
import org.inlakesh.banking.api.service.AccountService;
import org.inlakesh.banking.api.service.TransactionService;
import org.inlakesh.banking.api.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransferBussines transferBussines;

	@Autowired
	private TransactionService transactionService;

	@Override
	public void makeTransfer(TransactionDTO transaction) {

		try {
			// consultar cuenta "from"
			AccountDTO fromAccount = this.accountService.findByAccount(transaction.getFromAccount());

			// consultar cuenta "to"
			AccountDTO toAccount = this.accountService.findByAccount(transaction.getToAccount());

			// Validar fondos suficentes en cuenta "from"
			this.transferBussines.validateFunds(fromAccount.getBalance(), transaction.getAmout());

			// Realizar transferencia
			this.transferBussines.makeTransfer(fromAccount, toAccount, transaction.getAmout());

			// Definir fecha y hora en que se realizo la transferencia
			transaction.setSentAt(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

			// realizar transaccion
			this.makeTransaction(fromAccount, toAccount, TransactionMapper.INSTANCE.toEntity(transaction));

		} catch (InsuficientFundsException | NoDataFoundException e) {
			throw new TransferException(e.getMessage());
		}

	}

	@Transactional
	private void makeTransaction(AccountDTO fromAccount, AccountDTO toAccount, Transaction transaction)
			throws NoDataFoundException {
		this.accountService.updateAccount(fromAccount.getAccount(), fromAccount.getBalance());
		this.accountService.updateAccount(toAccount.getAccount(), toAccount.getBalance());
		this.transactionService.saveTransaction(transaction);
	}

}

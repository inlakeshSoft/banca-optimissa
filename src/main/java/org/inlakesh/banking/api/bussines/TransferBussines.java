package org.inlakesh.banking.api.bussines;

import java.math.BigDecimal;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.exception.InsuficientFundsException;
import org.springframework.stereotype.Component;

@Component
public class TransferBussines {

	/**
	 * Valida que despues de la transferencia 
	 * @param from
	 * @throws InsuficientFundsException
	 */
	public void validateFunds(BigDecimal balance, BigDecimal amount) throws InsuficientFundsException {
		if (balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0)
			throw new InsuficientFundsException("Los fondos de la cuenta origen son insuficientes");
	}

	/**
	 * Realiza la transferencia
	 * @param from
	 * @param to
	 */
	public void makeTransfer(AccountDTO from, AccountDTO to, BigDecimal amount) {
		from.setBalance(from.getBalance().subtract(amount));
		to.setBalance(to.getBalance().add(amount));
	}

}

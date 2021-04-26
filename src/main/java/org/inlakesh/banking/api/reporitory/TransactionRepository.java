package org.inlakesh.banking.api.reporitory;

import java.util.List;

import org.inlakesh.banking.api.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz con los metodos necesarios para la persitencia de datos de las
 * Transacciones
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByFromAccountOrToAccount(String fromAccount, String toAccount);

	List<Transaction> findByFromAccount(String fromAccount);

	List<Transaction> findByToAccount(String toAccount);

}

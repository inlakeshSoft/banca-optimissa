package org.inlakesh.banking.api.reporitory;

import java.util.Optional;

import org.inlakesh.banking.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz con los metodos necesarios para la persitencia de datos de las
 * Cuentas
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByAccount(String account);
	
}

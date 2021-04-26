package org.inlakesh.banking.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Objeto para tranferencia de datos de Transacciones   
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 9089465535866843105L;

	@EqualsAndHashCode.Include
	private String fromAccount;

	@EqualsAndHashCode.Include
	private String toAccount;

	@EqualsAndHashCode.Include
	private BigDecimal amout;

	@EqualsAndHashCode.Include
	private LocalDateTime sentAt;
}

package org.inlakesh.banking.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Objeto para tranferencia de datos de Cuentas   
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = 7767769829060074371L;

	@EqualsAndHashCode.Include
	private String account;

	@EqualsAndHashCode.Include
	private BigDecimal balance;

	@EqualsAndHashCode.Include
	private String owner;

	@EqualsAndHashCode.Include
	private LocalDateTime createdAt;
	
}

package org.inlakesh.banking.api.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TransactionRequest implements Serializable{
	
	private static final long serialVersionUID = 2548697763476903006L;

	@EqualsAndHashCode.Include
	@NotNull(message = "param fromAccount is required")
	@NotBlank(message = "param fromAccount should not be blank")
	private String fromAccount;

	@EqualsAndHashCode.Include
	@NotNull(message = "param toAccount is required")
	@NotBlank(message = "param toAccount should not be blank")
	private String toAccount;

	@EqualsAndHashCode.Include
	@NotNull(message = "param amount is required")
	@DecimalMin(value = "0.0", inclusive = false, message = "param amount must be higher than zero")
	private BigDecimal amount;
	
}

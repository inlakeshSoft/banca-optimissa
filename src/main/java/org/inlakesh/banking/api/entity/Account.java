package org.inlakesh.banking.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad Cuenta 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	@Column(name = "ACCOUNT", unique = true)
	private String account;

	@Column(name = "BALANCE", nullable = false, scale = 6)
	private BigDecimal balance;

	@Column(name = "OWNER", nullable = false)
	private String owner;

	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt;

}

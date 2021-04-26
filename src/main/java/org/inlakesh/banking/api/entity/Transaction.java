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
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 */
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FROM_ACCOUNT")
	@EqualsAndHashCode.Include
	private String fromAccount;
	
	@Column(name = "TO_ACCOUNT")
	@EqualsAndHashCode.Include
	private String toAccount;
	
	@Column(name = "AMOUNT")
	@EqualsAndHashCode.Include
	private BigDecimal amout;
	
	@Column(name = "SENT_AT")
	@EqualsAndHashCode.Include
	private LocalDateTime sentAt;
	
}

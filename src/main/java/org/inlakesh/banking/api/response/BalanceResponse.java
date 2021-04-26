package org.inlakesh.banking.api.response;

import java.io.Serializable;

import org.inlakesh.banking.api.dto.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BalanceResponse implements Serializable{

	private static final long serialVersionUID = 967642574473124872L;
	
	private AccountDTO balance; 

}

package org.inlakesh.banking.api.response;

import java.io.Serializable;
import java.util.List;

import org.inlakesh.banking.api.dto.TransactionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionResponse implements Serializable {

	private static final long serialVersionUID = 8241735914392832076L;
	
	private List<TransactionDTO> transactions;

}

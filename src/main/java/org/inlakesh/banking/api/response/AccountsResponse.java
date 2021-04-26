package org.inlakesh.banking.api.response;

import java.io.Serializable;
import java.util.List;

import org.inlakesh.banking.api.dto.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountsResponse implements Serializable {

	private static final long serialVersionUID = -6281212217514304406L;
	
	private List<AccountDTO> accounts;

}

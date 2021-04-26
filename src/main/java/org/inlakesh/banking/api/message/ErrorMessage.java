package org.inlakesh.banking.api.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private String message;
	
	private int status;

}

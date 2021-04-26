package org.inlakesh.banking.api.mapper;

import java.util.List;

import org.inlakesh.banking.api.dto.AccountDTO;
import org.inlakesh.banking.api.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Mapeador para Cuentas con los metodos para convertir DTO a Entidades y viceversa 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface AccountMapper {
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

	AccountDTO toDTO(Account account);

	Account toEntity(AccountDTO accountDto);
	
	List<AccountDTO> toDTO(List<Account> accounts);

}

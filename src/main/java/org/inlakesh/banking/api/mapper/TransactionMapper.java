package org.inlakesh.banking.api.mapper;

import java.util.List;

import org.inlakesh.banking.api.dto.TransactionDTO;
import org.inlakesh.banking.api.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Mapeador de Transaccion con los metodos para convertir DTO a Entidades y viceversa 
 * @author Felipe Perez Jaurez
 * @since 04-2021
 *
 */

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface TransactionMapper {

	TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

	TransactionDTO toDTO(Transaction transaction);

	Transaction toEntity(TransactionDTO transactionDto);
	
	List<TransactionDTO> toDTO(List<Transaction> transactions);
}

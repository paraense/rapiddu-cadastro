package br.com.rappidu.infra.mappers;


import br.com.rappidu.domain.entities.Customer;
import br.com.rappidu.infra.persistence.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    Customer toModel(CustomerEntity entity);
    CustomerEntity toEntity(Customer customer);
}

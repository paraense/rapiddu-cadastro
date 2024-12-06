package br.com.rappidu.infra.persistence.repositories;

import br.com.rappidu.infra.persistence.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByCpf(String cpf);
}

package br.com.rappidu.infra.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String cpf;

}

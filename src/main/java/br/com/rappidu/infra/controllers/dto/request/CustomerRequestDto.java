package br.com.rappidu.infra.controllers.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CustomerRequestDto {
    private String id;
    private String name;
    private String cpf;
}

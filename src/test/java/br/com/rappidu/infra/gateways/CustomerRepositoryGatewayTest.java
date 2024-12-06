package br.com.rappidu.infra.gateways;

import br.com.rappidu.domain.entities.Customer;
import br.com.rappidu.infra.mappers.CustomerEntityMapper;
import br.com.rappidu.infra.persistence.entities.CustomerEntity;
import br.com.rappidu.infra.persistence.repositories.CustomerRepository;
import br.com.rappidu.infra.persistence.repositories.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerRepositoryGatewayTest {

    @Mock
    private CustomerRepository repo;

    @Mock
    private CustomerEntityMapper mapper;

    @InjectMocks
    private CustomerRepositoryGateway gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCpf_CustomerExists() {
        // Arrange
        String cpf = "12345678900";
        CustomerEntity entity = new CustomerEntity(); // Mock do CustomerEntity
        Customer customer = new Customer(); // Mock do Customer

        when(repo.findByCpf(cpf)).thenReturn(Optional.of(entity));
        when(mapper.toModel(entity)).thenReturn(customer);

        // Act
        Customer result = gateway.findByCpf(cpf);

        // Assert
        assertNotNull(result);
        assertEquals(customer, result);

        verify(repo, Mockito.times(1)).findByCpf(cpf);
        verify(mapper, Mockito.times(1)).toModel(entity);
    }

    @Test
    void testFindByCpf_CustomerNotFound() {
        // Arrange
        String cpf = "12345678900";

        when(repo.findByCpf(cpf)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CustomerNotFoundException.class, () -> gateway.findByCpf(cpf));

        verify(repo, times(1)).findByCpf(cpf);
        verifyNoInteractions(mapper);
    }

    @Test
    void testSave() {
        // Arrange
        Customer customer = new Customer(); // Mock do Customer
        CustomerEntity entity = new CustomerEntity(); // Mock do CustomerEntity
        CustomerEntity savedEntity = new CustomerEntity(); // Entidade salva
        Customer savedCustomer = new Customer(); // Mock do Customer salvo

        when(mapper.toEntity(customer)).thenReturn(entity);
        when(repo.save(entity)).thenReturn(savedEntity);
        when(mapper.toModel(savedEntity)).thenReturn(savedCustomer);

        // Act
        Customer result = gateway.save(customer);

        // Assert
        assertNotNull(result);
        assertEquals(savedCustomer, result);

        verify(mapper, times(1)).toEntity(customer);
        verify(repo, times(1)).save(entity);
        verify(mapper, times(1)).toModel(savedEntity);
    }

}
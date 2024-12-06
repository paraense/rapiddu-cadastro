package br.com.rappidu.application.usecases;

import br.com.rappidu.application.gateways.CustomerGateway;
import br.com.rappidu.domain.entities.Cpf;
import br.com.rappidu.domain.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private FindCustomerUseCase findCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCpf() {
        // Arrange
        Cpf cpf = new Cpf("12345678900"); // Mock do CPF
        Customer customer = new Customer(); // Mock do cliente
        when(customerGateway.findByCpf(cpf.get())).thenReturn(customer);

        // Act
        Customer result = findCustomerUseCase.findByCpf(cpf);

        // Assert
        assertEquals(customer, result);
        verify(customerGateway, times(1)).findByCpf(cpf.get());
    }
}
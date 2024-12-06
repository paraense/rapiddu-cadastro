package br.com.rappidu.application.usecases;
import br.com.rappidu.application.gateways.CustomerGateway;
import br.com.rappidu.domain.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateCustomerUserCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private CreateCustomerUserCase createCustomerUserCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        // Arrange
        var inputCustomer = new Customer(); // Mock do cliente de entrada
        var savedCustomer = new Customer(); // Mock do cliente salvo

        when(customerGateway.save(inputCustomer)).thenReturn(savedCustomer);

        // Act
        Customer result = createCustomerUserCase.create(inputCustomer);

        // Assert
        assertEquals(savedCustomer, result);
        verify(customerGateway, times(1)).save(inputCustomer);
    }
}

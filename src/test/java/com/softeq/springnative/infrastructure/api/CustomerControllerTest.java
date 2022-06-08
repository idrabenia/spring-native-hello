package com.softeq.springnative.infrastructure.api;

import com.softeq.springnative.domain.Customer;
import com.softeq.springnative.infrastructure.api.dto.CustomerDto;
import com.softeq.springnative.infrastructure.api.dto.CustomerMapper;
import com.softeq.springnative.infrastructure.api.dto.CustomerMapperImpl;
import com.softeq.springnative.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @InjectMocks
    CustomerController controller;

    @Mock
    CustomerService service;

    @Spy
    CustomerMapper mapper = new CustomerMapperImpl();

    @BeforeEach
    void setUp() {
        mockCustomerService();
    }

    @Test
    void testCreateUser() {
        var customer = new CustomerDto(1, "A", "B");

        var result = controller.create(customer);

        assertEquals(1, result.getId());
        assertEquals("A", result.getFirstName());
        assertEquals("B", result.getLastName());
    }

    @Test
    void testFindAll() {
        var result = controller.findAll();

        assertEquals(1, result.size());
    }

    private void mockCustomerService() {
        var customer = new Customer(1, "A", "B");

        lenient()
                .doReturn(customer)
                .when(service)
                .save(any());

        lenient()
                .doReturn(List.of(customer))
                .when(service)
                .findAll();
    }

}

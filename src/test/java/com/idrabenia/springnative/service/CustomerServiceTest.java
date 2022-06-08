package com.idrabenia.springnative.service;

import com.idrabenia.springnative.domain.Customer;
import com.idrabenia.springnative.domain.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    CustomerService service;

    @Mock
    CustomerRepository repo;

    @BeforeEach
    void setUp() {
        lenient()
                .doReturn(List.of(new Customer(1, "A", "B")))
                .when(repo)
                .findAll();
    }

    @Test
    void testCreateCustomer() {
        var customer = new Customer(1, "Name", "LastName");

        service.save(customer);

        verify(repo).save(argThat(i -> {
            assertEquals("Name", i.getFirstName());
            assertEquals("LastName", i.getLastName());
            return true;
        }));
    }

    @Test
    void testFindAll() {
        Iterable<Customer> result = service.findAll();

        List<Customer> resultList = new ArrayList<>();
        result.forEach(resultList::add);
        assertEquals(1, resultList.size());
    }

}

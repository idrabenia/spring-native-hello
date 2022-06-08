package com.softeq.springnative.service;

import com.softeq.springnative.domain.Customer;
import com.softeq.springnative.domain.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepo;

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

}

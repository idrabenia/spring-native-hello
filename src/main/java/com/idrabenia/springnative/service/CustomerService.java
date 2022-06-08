package com.idrabenia.springnative.service;

import com.idrabenia.springnative.domain.Customer;
import com.idrabenia.springnative.domain.CustomerRepository;
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

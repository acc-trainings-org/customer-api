package com.acc.training.customerapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(@Valid Customer body) {
        return repository.saveCustomer(body);
    }

    public Customer getCustomer(String id) {
        return repository.fetchCustomer(id);
    }
    
}

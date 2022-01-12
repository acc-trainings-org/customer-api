package com.acc.training.customerapi.service;

import javax.validation.Valid;

import com.acc.training.customerapi.Repository.CustomerRepository;
import com.acc.training.customerapi.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(@Valid Customer body) {
        return repository.saveCustomer(body);
    }

    public Customer getCustomer(String id) {
        return repository.getCustomer(id);
    }

    
    
}

package com.acc.training.customer_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customer_api.repository.CustomerRepository;
import com.acc.training.customerapi.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer body) {
        return customerRepository.saveCustomer(body);
    }

    public Customer getCustomer(String id) {
        return customerRepository.fetchCustomer(id);
    }
    
}

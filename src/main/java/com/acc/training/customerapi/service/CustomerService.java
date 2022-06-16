package com.acc.training.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer (String id){
        return mapDomainToModel(repository.findByCustomerId(id));
    }

    public Customer createCustomer(Customer customer){
        CustomerDomain customerDomain = mapModelToDomain(customer);
        return mapDomainToModel(repository.save(customerDomain));
       
    }

    private Customer mapDomainToModel(CustomerDomain domain) {
        Customer customerObj = new Customer();
        customerObj.setCustomerAddress(domain.getCustomerAddress());
        customerObj.setCustomerId(domain.getCustomerId());
        customerObj.setCustomerName(domain.getCustomerName());
        customerObj.setOfficeCode(domain.getOfficeCode());
        return customerObj;    
    }

    public CustomerDomain mapModelToDomain(Customer customer){
        CustomerDomain custDomain = new CustomerDomain();
        custDomain.setCustomerAddress(customer.getCustomerAddress());
        custDomain.setCustomerId(customer.getCustomerId());
        custDomain.setCustomerName(customer.getCustomerName());
        custDomain.setOfficeCode(customer.getOfficeCode());
        return custDomain;
    }
}


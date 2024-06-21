package com.acc.training.customer_api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customer_api.domain.CustomerDomain;
import com.acc.training.customer_api.repository.CustomerRepository;
import com.acc.training.customerapi.model.Customer;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer createCustomer(@Valid Customer body) {
        return mapDomaintoModel(repository.save(mapModeltoDomain(body)));
    }

    public Customer getCustomer(String id) {
       return mapDomaintoModel( repository.findByCustomerId(id));
    }

    public CustomerDomain mapModeltoDomain(Customer customer){
        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setCustomerAddress(customer.getCustomerAddress());
        customerDomain.setCustomerId(customer.getCustomerId());
        customerDomain.setCustomerName(customer.getCustomerName());
        customerDomain.setOfficeCode(customer.getOfficeCode());
        return customerDomain;
    }


    public Customer mapDomaintoModel(CustomerDomain customerDomain){
        Customer customer = new Customer();
        customer.setCustomerAddress(customerDomain.getCustomerAddress());
        customer.setCustomerId(customerDomain.getCustomerId());
        customer.setCustomerName(customerDomain.getCustomerName());
        customer.setOfficeCode(customerDomain.getOfficeCode());
        return customer;
    }

    
}

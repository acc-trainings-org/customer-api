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
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return mapDomainToModel(customerRepository.save(mapModelToDomain(customer)));
    }
 
    public Customer getCustomer(String id) {
        return mapDomainToModel(customerRepository.findByCustomerId(id));
    }

    public CustomerDomain mapModelToDomain(Customer customer){

        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setCustomerId(customer.getCustomerId());
        customerDomain.setCustomerName(customer.getCustomerName());
        customerDomain.setCustomerAddress(customer.getCustomerAddress());
        customerDomain.setOfficeCode(customer.getOfficeCode());

        return customerDomain;
    }
    
    public Customer mapDomainToModel(CustomerDomain customerDomain){

        Customer customer = new Customer();
        customer.setCustomerId(customerDomain.getCustomerId());
        customer.setCustomerName(customerDomain.getCustomerName());
        customer.setCustomerAddress(customerDomain.getCustomerAddress());
        customer.setOfficeCode(customerDomain.getOfficeCode());

        return customer;
    }
}

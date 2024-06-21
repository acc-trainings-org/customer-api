package com.acc.training.customer_api.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customer_api.Repository.CustomerRepository;
import com.acc.training.customer_api.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;

@Service
public class CustomerService {
 
    @Autowired
    private CustomerRepository repository;
 
    public Customer createCustomer(@Valid Customer customer) {
        return mapDomainToModel(repository.save(mapModelToDomain(customer)));
    }
 
    public Customer getCustomer(String id) {
        return mapDomainToModel( repository.findByCustomerId(id));
    }
 
    public CustomerDomain mapModelToDomain(Customer customer){
 
        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setCustomerAddress(customer.getCustomerAddress());
        customerDomain.setCustomerId(customer.getCustomerId());
        customerDomain.setCustomerName(customer.getCustomerName());
        customerDomain.setOfficeCode(customer.getOfficeCode());
 
        return customerDomain;
    }
 
    public Customer mapDomainToModel(CustomerDomain customerDomain){
 
        Customer customer = new Customer();
        customer.setCustomerAddress(customerDomain.getCustomerAddress());
        customer.setCustomerId(customerDomain.getCustomerId());
        customer.setCustomerName(customerDomain.getCustomerName());
        customer.setOfficeCode(customerDomain.getOfficeCode());
 
        return customer;
    }
}

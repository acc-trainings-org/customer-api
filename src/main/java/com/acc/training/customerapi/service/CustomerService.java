package com.acc.training.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;
import com.acc.training.domain.CustomerDomain;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer(String id){
        return mapDomainToModel(repository.findByCustomerId(id));
    }

    public Customer createCustomer(Customer requestBody){
        return mapDomainToModel(repository.save(mapModelToDomain(requestBody)));
    }

    public Customer mapDomainToModel(CustomerDomain cm){
        Customer customer = new Customer();
        customer.setCustomerAddress(cm.getCustomerAddress());
        customer.setCustomerId(cm.getCustomerId());
        customer.setCustomerName(cm.getCustomerName());
        customer.setOfficeCode(cm.getOfficeCode());
        return customer;
    }
    
    public CustomerDomain mapModelToDomain(Customer customer){
        CustomerDomain cm = new CustomerDomain();
        cm.setCustomerAddress(customer.getCustomerAddress());
        cm.setCustomerId(customer.getCustomerId());
        cm.setCustomerName(customer.getCustomerName());
        cm.setOfficeCode(customer.getOfficeCode());
        return cm;
    }
}

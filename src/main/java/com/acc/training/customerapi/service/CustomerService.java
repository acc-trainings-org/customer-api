package com.acc.training.customerapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;


@Service
public class CustomerService {

    

    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(@Valid Customer body) {
            return mapDomainToModel(repository.save(mapModelToDomain(body)));
        }
    
        public Customer getCustomer(String id) {
            return mapDomainToModel(repository.findByCustomerId(id));
        }
    
        private CustomerDomain mapModelToDomain(Customer customer){
            CustomerDomain customerDomain = new CustomerDomain();
            customerDomain.setCustomerAddress(customer.getCustomerAddress());
            customerDomain.setCustomerId(customer.getCustomerId());
            customerDomain.setCustomerName(customer.getCustomerName());
            customerDomain.setOfficeCode(customer.getOfficeCode());
            return customerDomain;
        }
    
        private Customer mapDomainToModel(CustomerDomain customerDomain){
            Customer customer = new Customer();
            customer.setCustomerAddress(customerDomain.getCustomerAddress());
            customer.setCustomerId(customerDomain.getCustomerId());
            customer.setCustomerName(customerDomain.getCustomerName());
            customer.setOfficeCode(customerDomain.getOfficeCode());
            return customer;
        }

}

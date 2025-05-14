package com.acc.training.customer_api.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String, Customer> customerDB = new HashMap<>();

    static{
        initCustomerDB();
    }

    private static void initCustomerDB() {
        Customer customer = new Customer();
        customer.setCustomerId("12345");
        customer.setCustomerName("Sandeep Patil");
        customer.setCustomerAddress("Hartford, CT");
        customer.setOfficeCode(100);
        customerDB.put(customer.getCustomerId(), customer);
    }
    
        

    public Customer saveCustomer(Customer body) {
        return customerDB.put(body.getCustomerId(), body);
    }

    public Customer fetchCustomer(String id) {
        return customerDB.get(id);
    }
    
}

package com.acc.training.customer_api.repository;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final HashMap<String,Customer> customerDB=new HashMap<>();

    static{
        initCustomerDB();
    }

    public Customer saveCustomer(@Valid Customer body) {
        customerDB.put(body.getCustomerId(),body);
        return customerDB.get(body.getCustomerId());
    }

    private static void initCustomerDB() {
        Customer cust=new Customer();
        cust.setCustomerId("1");
        cust.setCustomerName("Accenture");
        cust.setCustomerAddress("Chennai");
        cust.setCustomercode(12345);
        customerDB.put(cust.getCustomerId(), cust);
        
    }

    public Customer fetchCustomer(String id) {
        return customerDB.get(id);
    }

}

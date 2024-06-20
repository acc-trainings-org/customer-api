package com.acc.training.customer_api.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String,Customer> customerDB=new HashMap<>();
    static{
        initCustomerDB();

    }
    public static void  initCustomerDB(){
        Customer cust=new Customer();
        cust.setCustomerId("101");
        cust.setCustomerName("SatheeshReddy");
        cust.setOfficeCode(1234);
        cust.setCustomerAddress("Bangalore-Whitefield");
        customerDB.put(cust.getCustomerId(), cust);
    }

    public Customer saveCustomer(@Valid Customer body) {
        customerDB.put(body.getCustomerId(),body);
        return customerDB.get(body.getCustomerId());
    }

    public Customer fetchCustomer(String id) {
     return customerDB.get(id);
    }

    
}

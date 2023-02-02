package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
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


    
    public Customer fetchCustomer(String id) {
        return customerDB.get(id);
    }

     

    private static void initCustomerDB() {
        Customer cust = new Customer();
        cust.setCustomerId("12345");
        cust.setCustomerName("Sandeep Patil");
        cust.setCustomerAddress("Hartford");
        cust.setOfficeCode(BigDecimal.valueOf(45));

        customerDB.put(cust.getCustomerId(), cust);


    }



    public Customer saveCustomer(Customer requestBody) {
        return customerDB.put(requestBody.getCustomerId(),requestBody);
    }
    
}

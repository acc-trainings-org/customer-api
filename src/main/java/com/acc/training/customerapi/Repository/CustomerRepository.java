package com.acc.training.customerapi.Repository;

import java.util.HashMap;
import java.util.Map;

import com.acc.training.customerapi.model.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private static final Map<String, Customer> customerMap = new HashMap<>();

    static{
        initCustomerDB();
        
    }

    private static void initCustomerDB() {

        Customer cust1 = new Customer();
        cust1.setCustomerId("12345");
        cust1.setCustomerName("Rahul Anaand");
        cust1.setCustomerAddress("Main Street");

        customerMap.put(cust1.getCustomerId(), cust1);

        Customer cust2 = new Customer();
        cust2.setCustomerId("23456");
        cust2.setCustomerName("Jessica");
        cust2.setCustomerAddress("New York");

        customerMap.put(cust2.getCustomerId(), cust2);

    }

    public Customer getCustomer(String id){
        return customerMap.get(id);

    }

    public Customer saveCustomer(Customer cust){
        customerMap.put(cust.getCustomerId(), cust);
        return customerMap.get(cust.getCustomerId());
    }  
    
}

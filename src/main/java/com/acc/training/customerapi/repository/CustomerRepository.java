package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {
    
    private static final Map<String,Customer> customerDB = new HashMap<>();

    static {
        initCustomerDB();
    }

    private static void initCustomerDB() {
        Customer cust1 = new Customer();
        cust1.setCustomerId("12345");
        cust1.setCustomerName("Siddharth Sethunatahn");
        cust1.setCustomerAddress("Hillsborough, NJ");
        cust1.setOfficeCode(BigDecimal.valueOf(045));
     
        customerDB.put(cust1.getCustomerId(),cust1);
    }

    public Customer getCustomer(String id){
        return customerDB.get(id);
    }
    
    public Customer saveCustomer(Customer customerObj){
        customerDB.put(customerObj.getCustomerId(), customerObj);
        return customerDB.get(customerObj.getCustomerId());
    }
}

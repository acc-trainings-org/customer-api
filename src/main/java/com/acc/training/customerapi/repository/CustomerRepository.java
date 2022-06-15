package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;

public interface CustomerRepository extends MongoRepository<CustomerDomain, String>{
    
    public CustomerDomain findByCustomerId(String customerId);
    public CustomerDomain findByCustomerAddress(String customerAddress);
    public CustomerDomain findByCustomerName(String customerName);
    public CustomerDomain findByOfficeCode(BigDecimal officeCode);

    /**
    private static final Map<String,Customer> customerDB = new HashMap<>();

    static {
        initCustomerDB();
    }
    
    private static void initCustomerDB() {
        Customer cust1 = new Customer();
        cust1.setCustomerId("12345");
        cust1.setCustomerName("Lloyd Dagoc");
        cust1.setCustomerAddress("New Hampshire, USA");
        cust1.setOfficeCode(BigDecimal.valueOf(045));
        customerDB.put(cust1.getCustomerId(), cust1);
    }
    
    public Customer getCustomer(String id){
        return customerDB.get(id);
    }

    public Customer saveCustomer(Customer customerObj){
        customerDB.put(customerObj.getCustomerId(), customerObj);
        return customerDB.get(customerObj.getCustomerId());
    }    
    */
}

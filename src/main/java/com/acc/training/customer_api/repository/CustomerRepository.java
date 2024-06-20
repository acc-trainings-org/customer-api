package com.acc.training.customer_api.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;

@Repository
public class CustomerRepository {

    private static final Map<String,Customer> CustomerDb = new HashMap();

    static{
        initCustomerDb();
    }

    private static void initCustomerDb() {
        // TODO Auto-generated method stub
       Customer cust = new Customer();
       cust.setCustomerId("345");
       cust.setCustomerName("Amruta Patil");
       cust.setCustomerAddress("Pune");
       cust.setOfficeCode(045);

       CustomerDb.put(cust.getCustomerId(), cust);
    }

    public Customer saveCustomer(@Valid Customer body) {
        // TODO Auto-generated method stub
        CustomerDb.put(body.getCustomerId(),body);
        return CustomerDb.get(body.getCustomerId());
    }

   

    public Customer fetchCustomer(String id) {
        // TODO Auto-generated method stub
       return CustomerDb.get(id);
    }
    
}

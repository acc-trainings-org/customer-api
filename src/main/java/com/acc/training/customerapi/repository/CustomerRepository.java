package com.acc.training.customerapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.acc.training.customerapi.domain.CustomerDomain;

public interface CustomerRepository extends MongoRepository<CustomerDomain, String> {
    
    public CustomerDomain findByCustomerId(String id); 
    
}

package com.acc.training.customer_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acc.training.domain.CustomerDomain;



public interface CustomerRepository extends MongoRepository<CustomerDomain, String> {

    CustomerDomain findByCustomerId(String customerId);
} 
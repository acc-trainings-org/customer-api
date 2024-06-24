package com.acc.training.customer_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acc.training.customer_api.domain.CustomerDomain;
import java.util.List;


public interface CustomerRepository extends MongoRepository<CustomerDomain, String>{
    CustomerDomain findByCustomerId(String customerId);
    

}

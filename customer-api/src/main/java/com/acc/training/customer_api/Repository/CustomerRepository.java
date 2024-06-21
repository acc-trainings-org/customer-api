package com.acc.training.customer_api.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acc.training.customer_api.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;


public interface CustomerRepository extends MongoRepository<CustomerDomain,String>
{
   
    CustomerDomain findByCustomerId(String customerId);

}


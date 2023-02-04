package com.acc.training.customerapi.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.domain.CustomerDomain;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDomain, String> {

    public CustomerDomain findByCustomerId(String customerId);
    public List<CustomerDomain> findByCustomerAddress(String customerAddress);
    
}

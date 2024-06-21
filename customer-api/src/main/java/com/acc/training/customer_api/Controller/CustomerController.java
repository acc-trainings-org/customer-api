package com.acc.training.customer_api.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.acc.training.customer_api.Service.CustomerService;
import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;

@RestController
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService service;


    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {
        Customer resp = service.createCustomer(body);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {
        Customer resp = service.getCustomer(id);
        if(null == resp){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resp);

     
    }

}

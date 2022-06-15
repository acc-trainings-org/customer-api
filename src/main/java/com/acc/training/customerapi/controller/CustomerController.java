package com.acc.training.customerapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;

import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.service.CustomerService;

@RestController
public class CustomerController implements CustomerApi{

    @Autowired
    private CustomerService service;


    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {
        
        // I still can post customers with invalid id without adding these few lines, why doesn't generated api code prevent this? 

        if ( !isValidId(body.getCustomerId()) ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Customer response = service.createCustomer(body);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {

        // This returns status code 400 instead of 404 if the id doesn't follow the length requirements.
        // Is there a way not to hardcode 2 and 10?
        
        if ( !isValidId(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Customer response = service.getCustomer(id);

        if(response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public boolean isValidId(String id) {
        return (id.length() < 2 || id.length() > 10) ? false : true;
    }
    
}

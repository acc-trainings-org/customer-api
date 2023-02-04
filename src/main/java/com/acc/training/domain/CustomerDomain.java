package com.acc.training.domain;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection="customer-training-angelacc")
public class CustomerDomain {

    private String customerId = null;
  
    private String customerName = null;
  
    private String customerAddress = null;
  
    private BigDecimal officeCode = null;

    @Id
    private String id;

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public BigDecimal getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(BigDecimal officeCode) {
        this.officeCode = officeCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId(){
        return customerId;
    }

}

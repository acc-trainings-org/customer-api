package com.acc.training.customer_api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "TrainingCollection")
public class CustomerDomain {

  @Id
  private String id;
  
  private String customerId = null;

  @JsonProperty("customerName")
  private String customerName = null;

  @JsonProperty("customerAddress")
  private String customerAddress = null;

  @JsonProperty("officeCode")
  private Integer officeCode = null;

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getCustomerId() {
    return customerId;
}

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

public Integer getOfficeCode() {
    return officeCode;
}

public void setOfficeCode(Integer officeCode) {
    this.officeCode = officeCode;
}

}

package com.acc.training.customerapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customer-training-sakthi")
public class CustomerDomain {
  
  @Id  
  private String id;

  private String customerId = null;

  private String customerName = null;

  private String customerAddress = null;


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


}
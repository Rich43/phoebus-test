package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomer(Long customerId);
    Long createCustomer(CustomerDTO customerDTO);
}

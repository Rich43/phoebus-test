package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomer(Long customerId);
    void createCustomer(CustomerDTO customerDTO);
}

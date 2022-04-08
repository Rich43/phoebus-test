package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO getCustomer(final Long customerId) {
        return null;
    }

    @Override
    public void createCustomer(final CustomerDTO customerDTO) {

    }
}

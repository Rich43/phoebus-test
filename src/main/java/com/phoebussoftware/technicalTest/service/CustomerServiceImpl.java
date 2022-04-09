package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO getCustomer(final Long customerId) {
        final Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByCustomerId(customerId);
        if (optionalCustomerEntity.isPresent()) {
            final CustomerEntity customerEntity = optionalCustomerEntity.get();
            return new CustomerDTO(
                    customerEntity.getCustomerId(),
                    customerEntity.getForeName(),
                    customerEntity.getSurName(),
                    customerEntity.getDateOfBirth(),
                    customerEntity.getAccountEntities().stream().map(
                            accountEntity -> new AccountDTO(accountEntity.getAccountId(), accountEntity.getAccountNumber())
                    ).collect(toList())
            );
        }

        return null;
    }

    @Override
    public Long createCustomer(final CustomerDTO customerDTO) {
        final CustomerEntity customerEntity = new CustomerEntity(
                null,
                customerDTO.foreName(),
                customerDTO.surName(),
                customerDTO.dateOfBirth(),
                emptyList()
        );
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return savedCustomer.getCustomerId();
    }
}

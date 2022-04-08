package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static java.util.Collections.singletonList;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    public static final int ACCOUNT_NUMBER = 345;
    public static final long ACCOUNT_ID = 2L;
    public static final long CUSTOMER_ID = 1L;
    public static final String FORE_NAME = "John";
    public static final String SUR_NAME = "Doe";

    @Mock
    CustomerRepository customerRepository;
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        this.customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void getCustomer() {
        final Date dateOfBirth = new Date();
        final AccountEntity accountEntity = new AccountEntity(ACCOUNT_ID, ACCOUNT_NUMBER);
        final CustomerEntity customerEntity = new CustomerEntity(
                CUSTOMER_ID,
                FORE_NAME,
                SUR_NAME,
                dateOfBirth,
                singletonList(accountEntity)
        );
        when(customerRepository.findById(1)).thenReturn(of(customerEntity));
        CustomerDTO customerDTO = customerService.getCustomer(1L);
        assertEquals(CUSTOMER_ID, customerDTO.customerId());
        assertEquals(FORE_NAME, customerDTO.foreName());
        assertEquals(SUR_NAME, customerDTO.surName());
        assertEquals(dateOfBirth, customerDTO.dateOfBirth());
        assertEquals(1, customerDTO.accountDTOS().size());
        assertEquals(ACCOUNT_ID, customerDTO.accountDTOS().get(0).accountId());
        assertEquals(ACCOUNT_NUMBER, customerDTO.accountDTOS().get(0).accountNumber());
    }

    @Test
    void getAccountByCustomerID() {

    }

    @Test
    void createCustomer() {
    }
}
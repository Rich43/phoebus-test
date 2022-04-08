package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    public static final int ACCOUNT_NUMBER = 456;
    public static final long ACCOUNT_ID = 123L;
    public static final int ACCOUNT_ID_INT = 123;
    public static final long CUSTOMER_ID = 789L;
    public static final int CUSTOMER_ID_INT = 789;
    public static final String FORE_NAME = "John";
    public static final String SUR_NAME = "Doe";

    @Mock
    AccountRepository accountRepository;
    @Mock
    CustomerRepository customerRepository;
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        this.accountService = new AccountServiceImpl(customerRepository, accountRepository);
    }

    @Test
    void getAccount() {
        // Arrange
        final AccountEntity accountEntity = new AccountEntity(ACCOUNT_ID, ACCOUNT_NUMBER);
        when(accountRepository.findById(ACCOUNT_ID_INT))
                .thenReturn(Optional.of(accountEntity));
        // Act
        final AccountDTO account = accountService.getAccount(ACCOUNT_ID);
        // Assert
        verify(accountRepository, times(1)).findById(ACCOUNT_ID_INT);
        assertEquals(account.accountNumber(), ACCOUNT_NUMBER);
        assertEquals(account.accountId(), ACCOUNT_ID);
    }

    @Test
    void createAccount() {
        // Arrange
        final Date dateOfBirth = new Date();
        final AccountEntity accountEntity = new AccountEntity(ACCOUNT_ID, ACCOUNT_NUMBER);
        final CustomerEntity customerEntity = new CustomerEntity(
                CUSTOMER_ID,
                FORE_NAME,
                SUR_NAME,
                dateOfBirth,
                singletonList(accountEntity)
        );
        when(accountRepository.save(accountEntity)).thenReturn(accountEntity);
        when(customerRepository.findById(CUSTOMER_ID_INT)).thenReturn(Optional.of(customerEntity));
        // Act
        final Long accountId = accountService.createAccount(CUSTOMER_ID, new AccountDTO(ACCOUNT_ID, ACCOUNT_NUMBER));
        // Assert
        verify(customerRepository, times(1)).findById(CUSTOMER_ID_INT);
        verify(accountRepository, times(1)).save(accountEntity);
        assertEquals(accountId, ACCOUNT_ID);
    }
}
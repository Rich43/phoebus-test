package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    public static final int ACCOUNT_NUMBER = 456;
    public static final long ACCOUNT_ID = 123L;
    public static final int ACCOUNT_ID_INT = 123;
    @Mock
    AccountRepository accountRepository;
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        this.accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    void getAccount() {
        AccountEntity accountEntity = new AccountEntity(ACCOUNT_ID, ACCOUNT_NUMBER);
        when(accountRepository.findById(ACCOUNT_ID_INT))
                .thenReturn(Optional.of(accountEntity));
        AccountDTO account = accountService.getAccount(ACCOUNT_ID);
        assertEquals(account.accountNumber(), ACCOUNT_NUMBER);
        assertEquals(account.accountId(), ACCOUNT_ID);
    }

    @Test
    void createAccount() {
    }
}
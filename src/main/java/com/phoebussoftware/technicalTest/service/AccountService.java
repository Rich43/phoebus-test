package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;

public interface AccountService {
    AccountDTO getAccount(Long accountId);
    void createAccount(AccountDTO accountDTO);
}

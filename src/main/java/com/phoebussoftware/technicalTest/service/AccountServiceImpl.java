package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.phoebussoftware.technicalTest.factories.AccountEntityFactory.createAccountEntity;

@Service
public class AccountServiceImpl implements AccountService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(final CustomerRepository customerRepository, final AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO getAccount(final Long accountId) {
        final Optional<AccountEntity> accountEntityOptional = accountRepository.findByAccountId(accountId);
        if (accountEntityOptional.isPresent()) {
            final AccountEntity accountEntity = accountEntityOptional.get();
            return new AccountDTO(accountEntity.getAccountId(), accountEntity.getAccountNumber());
        }
        return null;
    }

    @Override
    public Long createAccount(Long customerId, AccountDTO accountDTO) {
        final Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByCustomerId(customerId);
        if (optionalCustomerEntity.isPresent()) {
            final CustomerEntity customerEntity = optionalCustomerEntity.get();
            // Todo: Add better exception handling to give the user more information
            final AccountEntity accountEntity = createAccountEntity(accountDTO.accountNumber());
            AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
            customerEntity.addAccountEntity(savedAccountEntity);
            customerRepository.save(customerEntity);
            return savedAccountEntity.getAccountId();
        }
        return null;
    }
}

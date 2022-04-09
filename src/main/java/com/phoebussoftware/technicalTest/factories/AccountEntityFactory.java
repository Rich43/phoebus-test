package com.phoebussoftware.technicalTest.factories;

import com.phoebussoftware.technicalTest.model.AccountEntity;

public class AccountEntityFactory {
    public static AccountEntity createAccountEntity(final Integer accountNumber) {
        return new AccountEntity(null, accountNumber);
    }
}

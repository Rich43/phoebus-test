package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByAccountId(Long accountId);
}

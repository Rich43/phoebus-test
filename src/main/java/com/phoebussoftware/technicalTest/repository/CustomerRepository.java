package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findById(Long customerId);
}

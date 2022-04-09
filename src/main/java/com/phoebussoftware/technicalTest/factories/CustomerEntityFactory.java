package com.phoebussoftware.technicalTest.factories;

import com.phoebussoftware.technicalTest.model.CustomerEntity;

import java.util.Date;

import static java.util.Collections.emptyList;

public class CustomerEntityFactory {
    public static CustomerEntity createCustomerEntity(final String foreName, final String surName, final Date dateOfBirth) {
        return new CustomerEntity(null, foreName, surName, dateOfBirth, emptyList());
    }
}

package com.phoebussoftware.technicalTest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
  @Id Long accountId;
  Integer accountNumber;

  public AccountEntity() {
  }

  public AccountEntity(final Long accountId, final Integer accountNumber) {
    this.accountId = accountId;
    this.accountNumber = accountNumber;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }
}

package com.phoebussoftware.technicalTest.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
  @Id Long customerId;
  @NotNull @Column(nullable = false) String foreName;
  @NotNull @Column(nullable = false) String surName;
  @NotNull @Column(nullable = false) Date dataOfBirth;

  @OneToMany List<AccountEntity> accountEntities;

  public CustomerEntity() {
  }

  public CustomerEntity(final Long customerId, final String foreName,
                        final String surName, final Date dataOfBirth,
                        final List<AccountEntity> accountEntities) {
    this.customerId = customerId;
    this.foreName = foreName;
    this.surName = surName;
    this.dataOfBirth = dataOfBirth;
    this.accountEntities = accountEntities;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getForeName() {
    return foreName;
  }

  public void setForeName(String foreName) {
    this.foreName = foreName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public Date getDataOfBirth() {
    return dataOfBirth;
  }

  public void setDataOfBirth(Date dataOfBirth) {
    this.dataOfBirth = dataOfBirth;
  }

  public List<AccountEntity> getAccountEntities() {
    return accountEntities;
  }

  public void setAccountEntities(List<AccountEntity> accountEntities) {
    this.accountEntities = accountEntities;
  }
}

package com.phoebussoftware.technicalTest.DTO;

public record AccountDTO (
  Long accountId,
  CustomerDTO customerDTO,
  Integer accountNumber
){ }

package com.phoebussoftware.technicalTest.DTO;

import java.util.Date;
import java.util.List;

public record CustomerDTO (
  Long customerId,
  String foreName,
  String surName,
  Date dateOfBirth,
  List<AccountDTO> accountDTOS
){}

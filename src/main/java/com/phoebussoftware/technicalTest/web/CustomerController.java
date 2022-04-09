package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable final Long customerId) {
    return ok(new CustomerDTO(customerId, "", "", new Date(), emptyList()));
  }

  @GetMapping("/account/{customerId}")
  public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(@PathVariable final Long customerId) {
    final List<AccountDTO> accountDTOS = List.of(new AccountDTO(0L, 0));
    return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
  }
}

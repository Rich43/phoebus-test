package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable final Long customerId) {
    return ok(customerService.getCustomer(customerId));
  }

  @GetMapping("/account/{customerId}")
  public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(@PathVariable final Long customerId) {
    return new ResponseEntity<>(customerService.getCustomer(customerId).accounts(), HttpStatus.OK);
  }

  @PostMapping("/customer/create")
  public ResponseEntity<Long> createCustomer(@RequestBody final CustomerDTO customerDTO) {
    return ok(customerService.createCustomer(customerDTO));
  }
}

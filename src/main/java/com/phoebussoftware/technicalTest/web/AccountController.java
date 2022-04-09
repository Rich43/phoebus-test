package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/account")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDTO> getAccountById(@PathVariable final Long accountId) {
    return ok(accountService.getAccount(accountId));
  }

  @PostMapping("/account/create/{customerId}")
  public ResponseEntity<Long> createAccount(@PathVariable final Long customerId, @RequestBody final AccountDTO accountDTO) {
    return ok(accountService.createAccount(customerId, accountDTO));
  }
}

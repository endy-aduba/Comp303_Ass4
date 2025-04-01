package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	@Autowired
    private AccountService accountService;

    @PostMapping("/account/reserve")
    public ResponseEntity<String> reserve(@RequestBody String orderJson) {
        return accountService.reserveFunds(orderJson);
    }

    @PostMapping("/account/create")
    public ResponseEntity<String> create(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
}

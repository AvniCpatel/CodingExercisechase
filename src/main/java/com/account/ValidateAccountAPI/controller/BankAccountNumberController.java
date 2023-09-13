package com.account.ValidateAccountAPI.controller;


import com.account.ValidateAccountAPI.model.AccountValidateRequest;
import com.account.ValidateAccountAPI.model.AccountValidateResponse;
import com.account.ValidateAccountAPI.service.AccountNumberValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountNumberController {

    @Autowired
    private AccountNumberValidationService accountNumberValidationService;

    @GetMapping(value = "/validateBankAccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountValidateResponse validateBankAccount(@RequestBody AccountValidateRequest acccountValidateRequest) {

        return accountNumberValidationService.validateAccountNumber(acccountValidateRequest);

    }


}

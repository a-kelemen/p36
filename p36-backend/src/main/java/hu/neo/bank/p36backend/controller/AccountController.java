package hu.neo.bank.p36backend.controller;

import hu.neo.bank.p36backend.service.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceInterface accountService;
}

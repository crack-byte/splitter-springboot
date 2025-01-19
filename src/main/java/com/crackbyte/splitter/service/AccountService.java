package com.crackbyte.splitter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crackbyte.splitter.entities.Account;
import com.crackbyte.splitter.respository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }
}

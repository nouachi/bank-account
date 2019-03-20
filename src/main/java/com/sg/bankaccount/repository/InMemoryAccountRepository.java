package com.sg.bankaccount.repository;

import com.sg.bankaccount.domain.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryAccountRepository implements AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        if(account != null) {
            account.setId(UUID.randomUUID().toString());
            accounts.add(account);
        }
        return account;
    }

    @Override
    public Account findById(String id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

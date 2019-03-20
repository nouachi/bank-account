package com.sg.bankaccount.repository;

import com.sg.bankaccount.domain.Account;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class InMemoryAccountRepositoryTest {

    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        accountRepository = new InMemoryAccountRepository();
    }

    @Test
    public void can_save_an_account() {
        Account account = accountRepository.save(new Account());

        assertNotNull(account.getId());
    }


    @Test
    public void can_find_an_account() {
        Account account = accountRepository.save(new Account());

        Account foundedAccount = accountRepository.findById(account.getId());

        assertThat(account, CoreMatchers.is(foundedAccount));
    }
}

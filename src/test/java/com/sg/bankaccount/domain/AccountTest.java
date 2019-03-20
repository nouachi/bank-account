package com.sg.bankaccount.domain;

import com.sg.bankaccount.domain.Account;
import com.sg.bankaccount.domain.operation.DepositOperation;
import com.sg.bankaccount.domain.operation.WithdrawOperation;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void when_new_account_created_total_balance_should_be_zero() {
        assertThat(account.totalBalance(), is(.0));
    }

    @Test
    public void when_deposit_operation_processed_should_increase_total_balance_by_amount() {
        account.process(new DepositOperation(LocalDateTime.parse("2007-12-03T10:15:30.00"), 100));
        assertThat(account.totalBalance(), is(100.0));
    }

    @Test
    public void when_deposit_and_withdrawal_operation_processed_should_compute_total_balance() {
        account.process(new DepositOperation(LocalDateTime.parse("2007-12-03T10:15:30.00"), 350.95));
        account.process(new WithdrawOperation(LocalDateTime.parse("2007-12-03T10:15:30.00"), 200.23));
        assertThat(account.totalBalance(), is(150.72));
    }
}

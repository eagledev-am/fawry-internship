package org.example.account;

import org.example.account.AccountManager;
import org.example.account.AccountManagerImpl;
import org.example.account.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class AccountImpTest {

    Customer customer;
    AccountManager accountManager;

    final int GREATEST_AMOUNT = 2000;
    final int DEFAULT_AMOUNT = 1000;
    final int SMALLEST_AMOUNT = 500;
    final String WITHDRAW_SUCCESSFUL = "success";
    final String INSUFFICIENT_ACCOUNT = "insufficient account balance";
    final String MAXIMUM_CREDIT_EXCEEDED = "maximum credit exceeded";
    @BeforeEach
    void setup(){
      customer = new Customer();
      accountManager = new AccountManagerImpl();
    }

    @Test
    void testDepositingOperation(){

        // arrange
        customer = new Customer();
        accountManager = new AccountManagerImpl();
        // act
        accountManager.deposit(customer , DEFAULT_AMOUNT);
        // assert
        assertThat(customer.getBalance()).isEqualTo(DEFAULT_AMOUNT);

    }

    @Test
    void testWithDrawExBalanceGreaterThanZero(){
        // arrange
        customer.setBalance(GREATEST_AMOUNT);
        // act
        String result = accountManager.withdraw(customer , DEFAULT_AMOUNT);
        // assert
        assertThat(result).isEqualTo(WITHDRAW_SUCCESSFUL);
        // check bl
    }

    @Test
    void testWithDrawExBalanceLessThanZeroAndNotCreditAllowed(){
        // arrange
        customer.setBalance(SMALLEST_AMOUNT);
        customer.setCreditAllowed(false);
        // act
        String result = accountManager.withdraw(customer , DEFAULT_AMOUNT); // -500
        // assert
        assertThat(result).isEqualTo(INSUFFICIENT_ACCOUNT);
    }

    @Test
    void testWithDrawExBalanceLessThanZeroAndGreaterThanMxCreditAndNotVip(){
        // arrange
        customer.setBalance(SMALLEST_AMOUNT);
        customer.setCreditAllowed(true);
        customer.setVip(false);
        // act
        String result = accountManager.withdraw(customer , GREATEST_AMOUNT);
        // assert
        assertThat(result).isEqualTo(MAXIMUM_CREDIT_EXCEEDED);
    }

    @Test
    void testWithDrawExBalanceLessThanZeroAndGreaterThanMxCreditAndISVip(){
        // arrange
        customer.setBalance(SMALLEST_AMOUNT);
        customer.setCreditAllowed(true);
        customer.setVip(true);
        // act
        String result = accountManager.withdraw(customer , GREATEST_AMOUNT);
        // assert
        assertThat(result).isEqualTo(WITHDRAW_SUCCESSFUL);
    }


}

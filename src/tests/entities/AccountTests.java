package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	//valor do saldo tem que ser igual ao expectedValue
	@Test
	public void depositShoudIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.00;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	//quando o valor do deposito for negativo, ignorar, saldo deverá ser o inicial
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	//teste para saque total. saldo final = 0
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	//teste para saque com saldo suficiente
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		acc.withdraw(500.0);
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	//teste para saque com saldo insuficiente
	@Test
	public void withdrawShouldDecreaseBalanceWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(900.0);
		});
	}
}

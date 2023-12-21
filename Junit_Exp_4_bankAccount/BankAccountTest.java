import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void testGetBalance() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit some amount
		account.deposit(100);
		assertEquals(100, account.getBalance(), "Balance should be 100 after deposit");
	}

	@Test
	void testDeposit() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit some amount
		account.deposit(100);
		assertEquals(100, account.getBalance(), "Balance should be 100 after deposit");
		// Deposit another amount
		account.deposit(50);
		assertEquals(150, account.getBalance(), "Balance should be 150 after another deposit");
	}

	@Test
	void testDepositNegativeAmount() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Attempt to deposit a negative amount
		assertThrows(IllegalArgumentException.class, () -> account.deposit(-50),
				"Should throw IllegalArgumentException for negative deposit amount");
	}

	@Test
	void testDepositFractionalAmount() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit a fractional amount
		account.deposit(75.50);
		assertEquals(75.50, account.getBalance(), "Balance should be 75.50 after fractional deposit");
	}

	@Test
	void testWithdraw() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit some amount
		account.deposit(100);
		assertEquals(100, account.getBalance(), "Balance should be 100 after deposit");
		// Withdraw some amount
		account.withdraw(50);
		assertEquals(50, account.getBalance(), "Balance should be 50 after withdrawal");
		// Withdraw another amount
		account.withdraw(25);
		assertEquals(25, account.getBalance(), "Balance should be 25 after another withdrawal");
	}

	@Test
	void testWithdrawNegativeAmount() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Attempt to withdraw a negative amount
		assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50),
				"Should throw IllegalArgumentException for negative withdrawal amount");
	}

	@Test
	void testWithdrawFractionalAmount() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit some amount
		account.deposit(100);
		// Withdraw a fractional amount
		account.withdraw(25.50);
		assertEquals(74.50, account.getBalance(), "Balance should be 74.50 after fractional withdrawal");
	}

	@Test
	void testWithdrawMoreThanBalance() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance(), "Initial balance should be 0");
		// Deposit some amount
		account.deposit(50);
		assertEquals(50, account.getBalance(), "Balance should be 50 after deposit");
		// Attempt to withdraw an amount greater than the balance
		assertThrows(RuntimeException.class, () -> account.withdraw(100),
				"Should throw RuntimeException for withdrawal exceeding balance");
	}
}

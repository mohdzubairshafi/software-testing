public class BankAccount {
	private double balance;

	public BankAccount() {
		this.balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Deposit amount must be non-negative");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal amount must be non-negative");
		}

		if (amount > balance) {
			throw new RuntimeException("Insufficient funds for withdrawal");
		}

		balance -= amount;
	}
}

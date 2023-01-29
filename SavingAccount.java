package class02_2;

public class SavingAccount extends BankAccount{
	
	private double interestRate;

	
	public SavingAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}
}

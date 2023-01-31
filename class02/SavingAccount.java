package class02;

public class SavingAccount extends BankAccount{
	private double interestRate;
	
	public SavingAccount(int balance,double interestRate) {
		super(balance);
		this.interestRate =interestRate;

	}
	
	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}
	public String getAccountType() {
		return "저축예금";	
	}
}

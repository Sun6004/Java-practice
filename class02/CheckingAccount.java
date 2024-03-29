package class02;

public class CheckingAccount extends BankAccount{
	private SavingAccount protectedBy;	
	public CheckingAccount(int balance) {
		super(balance);
	}
	public CheckingAccount(int balance, SavingAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
	@Override
	public boolean withdraw(int amount) {
		if (amount > balance) {
			protectedBy.balance -= amount - balance;
			balance = 0;
			return true;
		}
		return super.withdraw(amount);
	}
	public String getAccountType(){
		return "당좌예금";
	}
}

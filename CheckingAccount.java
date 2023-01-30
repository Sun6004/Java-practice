package class02_2;

public class CheckingAccount extends BankAccount{
	private SavingAccount protectedBy;

	public CheckingAccount(int balance){
		super(balance);
	}

	public CheckingAccount(int balance, SavingAccount protectedBy){
		super(balance);
		this.protectedBy = protectedBy;
	}
	
	@Override
	public boolean withdraw(int amount) {
		if (balance + protectedBy.balance< amount) { 
			return false;
		} else if (balance < amount) {
			protectedBy.withdraw(amount - balance);
			balance -= balance;
			return true;
		} else {
			super.withdraw(amount);
			return true;
		}
		// if(super.withdraw(amount){
		//	return true;
		//  }else{
		//	protectedBy.balance -= amount - balance;
		//	balance = 0;
		//}	return super.withfraw(amount);
		//}
	}
}

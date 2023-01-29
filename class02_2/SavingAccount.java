package class02_2;

public class SavingAccount extends BankAccount{
	private double interestRate; // 이자율

	// 생성자
	public SavingAccount(int balance, double interestRate) {
		super(balance); // 초기화
		this.interestRate = interestRate;
	}

	// 메소드
	public void updateBalance(int period) {// 이자를 계산하여 잔액에 추가
		balance += balance * interestRate * period;
	}
}

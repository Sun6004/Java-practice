package class02;

public class BankAccount {
	private int blance;
	
		public BankAccount(int blance) {
			this.blance=blance;
		}

		public int getBlance() {
			return blance;
		}
		
		//입금 메소드
		public void deposit(int amoint) {
			
		}
		//출금 메소드
		public boolean withdraw(int amoint) {
			return false;
			
			
		}
		//현재 계좌에서 amount 만큼을 다른 계좌로 송금하는 메소드
		public boolean transfer(int amount) {
			return false;
			
		}
	
}

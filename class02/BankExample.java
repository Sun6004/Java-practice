package class02;

import class02.BankAccount;
import class02.CheckingAccount;

public class BankExample {
		public static void main(String[] args) {
			
			//BankAccount.balance : 3000
			CheckingAccount tonyAccount = new CheckingAccount(3000);
			//BankAccount.balance : 4000
			CheckingAccount steveAccount = new CheckingAccount(4000);
			
			try {
				//tony가 steve에게 5000원 송금->송금불가
				tonyAccount.transfer(5000, steveAccount);
				System.out.println("송금 완료");
			} catch (NullPointerException e) {
				System.out.println("해당하는 계좌가 없습니다.");
				System.out.println("송금 실패");
			} catch (IllegalArgumentException e) {
				System.out.println("해당하는 금액을 보낼 수 없습니다.");
				System.out.println("송금 실패");
			}
			
			try {
				tonyAccount.transfer(2000, null);
				System.out.println("송금 완료");
			} catch (NullPointerException e) {
				System.out.println("해당하는 계좌가 없습니다.");
				System.out.println("송금 실패");
			} catch (IllegalArgumentException e) {
				System.out.println("해당하는 금액을 보낼 수 없습니다.");
				System.out.println("송금 실패");
			}
		}
	}


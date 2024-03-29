package threadTest;

//은행의 입출금을 쓰레드로 처리하는 예제 (동기화 처리 예제)
public class ThreadTest16 {
	private int balance; //잔액 저장 변수
	
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	//입금하는메소드
	public void deposit(int money) {
		balance += money;
		
	}
	
	//출금하는 메소드 (성공: true, 실패: false)
	public synchronized boolean withdraw(int money) {
		int temp = 0;
		if(balance >= money) {
		
			for (int i = 1; i < 100000000; i++) { //시간을 지연시켜 오류를 확인하기 위함
			temp++;
		}		
		balance -= money;
		System.out.println("메소드 안에서 balance: "+balance);
		return true;
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		ThreadTest16 acount = new ThreadTest16();
		acount.setBalance(10000); //잔액설정
		
		//익명 구현체로 쓰레드 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); //출금
				System.out.println("쓰레드에서 result = " + result + ", balance: " + acount.getBalance());
				
			}
		};
		
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();

	}
}

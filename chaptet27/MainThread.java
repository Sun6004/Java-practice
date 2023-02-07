package chaptet27;

public class MainThread {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1(); //User1 스레드 생성
		user1.setCalculator(calculator); //공유객체 생성
		user1.start();//스레드 시작
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}

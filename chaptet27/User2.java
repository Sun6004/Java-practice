package chaptet27;

public class User2 extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User2"); //스레드 이름설정
		this.calculator = calculator;//공유객체Caluclator을 필드에 저장
	}
	
	public void run() {
		calculator.setMemory(50);
	}
}

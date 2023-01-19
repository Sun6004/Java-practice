package chapter14;

public class Calculator {

	void powerOn() {
		System.out.println("전원을 켭니다.");
//		plus(10,20);
//		powerOff();
//		divide(20,10);
	}

	int plus(int x, int y) { // int x=10, int y=20;
		return x + y;

	}

	double divide(int x, int y) {
		double sum = plus(x, y);
		return (double) sum / 2;
	}

	void execute() {
		double result = divide(7, 10);
		println("실행결과: " + result);
	}

	void println(String message) {
		System.out. println(message);
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

}

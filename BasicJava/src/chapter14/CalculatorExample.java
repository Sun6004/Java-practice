package chapter14;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator mycal = new Calculator();
		
		int result = mycal.plus(5, 6);
		System.out.println(result);
		
		byte x =10;
		byte y =4;
		double result2 = mycal.divide(x, y);
		System.out.println(result2);
		
		mycal.powerOff();
		
		mycal.execute();
	}

}

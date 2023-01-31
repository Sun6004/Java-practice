package chapter20;

public class CarEx {
	public static void main(String[] args) {
		Car mycar = new Car();
		
		mycar.run();
		
		System.out.println();
		
		mycar.flTire = new KumhoTire();
		mycar.frTire = new KumhoTire();
		
		mycar.run();
	}
}

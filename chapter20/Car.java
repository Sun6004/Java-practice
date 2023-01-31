package chapter20;

public class Car {
	Tire frTire = new HankookTire(); 
	Tire flTire = new HankookTire(); 
	Tire brTire = new HankookTire(); 
	Tire blTire = new HankookTire(); 
	
	void run() {
		flTire.roll();
		frTire.roll();
		blTire.roll();
		brTire.roll();
	}
}

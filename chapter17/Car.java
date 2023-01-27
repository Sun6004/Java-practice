package chapter17;

public class Car {
	//필드
	
	//포함관계(has a) Car has a Tire
	Tire flTire = new Tire("앞왼쪽",6);
	Tire frTire = new Tire("앞오른쪽",2);
	Tire blTire = new Tire("뒤왼쪽",3);
	Tire brTire = new Tire("뒤오른쪽",4);
	//생성자0
	
	//메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(flTire.roll()==false) {stop(); return 1; }
		if(frTire.roll()==false) {stop(); return 2; }
		if(blTire.roll()==false) {stop(); return 3; }
		if(brTire.roll()==false) {stop(); return 4; }
		return 0;
	}
		
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}

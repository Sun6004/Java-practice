package chapter14;

public class Car {
	int gas;
	int speed;
	int maxSpeed;
	
	int getSpeed() {
		return speed;
	}
	
	
	void keyTurn() {
		System.out.println("키를 돌립니다.");
	}
	
	void drive() {
		for(int i=10; i<=80; i+=10) {
			speed = i;
			System.out.println("달립니다.(시속:"+speed+"km/h)");
		}
	}
	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean leftGas() {
		if(gas ==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas >0) {
				System.out.println("달린다.(gas잔량:"+gas+")");
				gas -=1;
			}else {
				System.out.println("멈춘다.(gas잔량:"+gas+")");
				return;
			}
		}
	}
}

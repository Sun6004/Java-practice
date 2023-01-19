package chapter14;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();

		myCar.keyTurn();{
		System.out.println("출발");
		}
		myCar.drive();		
		
		int speed = myCar.speed;
		System.out.println("현재속도: " + speed + "km/h");

		myCar.setGas(5);

		boolean gasState = myCar.leftGas();
		if (gasState) {
			myCar.run();
		}

		if (myCar.leftGas()) {
			System.out.println("gas를 주입할 필요없음.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}

}

package chapter17;

public class DriverEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);//자동 타입변환: Vehicle vehicle = bus;
		driver.drive(taxi);//자동 타입변환: Vehicle vehicle = taxi;

	}
}

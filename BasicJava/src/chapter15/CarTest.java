package chapter15;

public class CarTest {

	public static void main(String[] args) {
		Car mycar = new Car("red");
		System.out.println("color: " + mycar.getColor());
		System.out.println("maxSpeed"+Car.getMaxSpeed()+"km/h");

	}

}

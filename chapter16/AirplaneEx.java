package chapter16;

public class AirplaneEx {

	public static void main(String[] args) {
		SuperAirplane sa = new SuperAirplane();
		sa.off();
		sa.fly();
		sa.flyMode = SuperAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SuperAirplane.NOMAL;
		sa.fly();
		sa.land();
	}

}

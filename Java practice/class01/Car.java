package class01;

public class Car {
	private double speed;
	private String color;
	private static final double MAX_SPEED =200;
	
	private static double killoTomile(double distance) {
		return distance / 1.6;
	}
	private static double mileTokillo(double distance) {
		return 1.6 * distance;
	}	
	public Car() {
	
	}
	public Car(String color) {
		this.color = color;
	}
	
	public double getSpeed() {
		return mileTokillo(speed);
	}
	public void setSpeed(double speed) {
		
		this.speed = killoTomile(speed);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean speedUp(double speed) {
			if( speed > 0 && speed < 200) {
			this.speed += killoTomile(speed);
			return true;		
	}else {
		return false;
		 }
	}
	public static double getMaxSpeed() {
		return mileTokillo(MAX_SPEED);
		
	}
}

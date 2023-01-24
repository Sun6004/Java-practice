package class01;

public class Car {
	private double speed;
	private String color;
	private static final double MAX_SPEED =200;
	
	public Car() {
	
	}
	public Car(String color) {
		this.color = color;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean speedUp(double speed) {
			if( speed > 0 && speed < 200) {
			this.speed += speed;
			return true;		
	}else {
		this.speed = 0;	
		return false;
		 }
	}
	public static double getMaxSpeed() {
		return MAX_SPEED;
	}
}

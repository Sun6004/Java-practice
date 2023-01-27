package chapter18;

public class Circle {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return radius*radius*Math.PI;
	}
	public double perimeter() {
		return  radius*2*Math.PI;
	}
}

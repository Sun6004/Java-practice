package chapter18;

public class Triangle extends Shape{
	private double side;
	public Triangle(double side) {
		this.side=side;
	}
	public double area() {
		return side*side;
	}
	public double perimeter() {
		return side*3;
	}
}

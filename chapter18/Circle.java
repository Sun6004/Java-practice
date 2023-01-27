package chapter18;

public class Circle extends Shape{
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

	@Override
	public String toString() {
		return "도형의 종류: 원, 둘레: " + (double)area() + ", 넓이: " +(double)perimeter();
	}
}

package chapter18;

public class Triangle extends Shape{
	static double s;
	private double side;
	public Triangle(double side) {
		this.side=side;
	}
	public double area() {
		s =  (side*3)/2.0;
		return Math.sqrt(s*(s-side)*(s-side)*(s-side));
	}
	public double perimeter() {
		return side*3;
	}
	@Override
	public String toString() {
		return "도형의 종류: 삼각형, 둘레: "+(double)perimeter()+"넓이: "+ (double)area()+"㎠";
	}
}

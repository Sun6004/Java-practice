package chapter18;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {

		this.height=height;
		this.width=width;	
	}
	public double area() {

		return width* height;
	}
	public double perimeter() {

		return ((width+height)*2);
	}
	@Override
	public String toString() {
		return "도형의 종류: 사각형, 둘레:"+perimeter()+"Cm, 넓이:"+area();
	}
	
	
}

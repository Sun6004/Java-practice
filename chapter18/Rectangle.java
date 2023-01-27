package chapter18;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		System.out.println("도형의 종류: 사각형");
		this.height=height;
		this.width=width;	
	}
	public double area() {
		System.out.println("넓이: ");
		return width* height;
	}
	public double perimeter() {
		System.out.print("둘레: ");
		return ((width+height)*2);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}

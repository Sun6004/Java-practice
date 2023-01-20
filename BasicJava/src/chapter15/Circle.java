package chapter15;

public class Circle {
	
	private double radius;
	private double x;
	private double y;
	private double area;

	public double getArea() {
		double result = Math.PI * getRadius() * getRadius();
		return result;	
	}
	public void setArea(double area) {
		
		 this.area = area;
		
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius>0) {
		this.radius = radius;
		}
	}

	

	

	
}
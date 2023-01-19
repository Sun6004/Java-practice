package chapter14;

import java.util.Scanner;

public class exam {
	double area(double width) {
		return width * width;
	}

	double area(double width, double height) {
		return width * height;
	}

	public static void main(String[] args) {
		exam mycal = new exam();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정사각형의 넓이구하기: ");
		double result1 = mycal.area(sc.nextDouble());
		
		System.out.println("직사각형의 넓이구하기: ");
		System.out.print("한쪽 변의 길이: ");
		double x = sc.nextDouble();
		System.out.print("나머지 변의 길이: ");
		double y = sc.nextDouble();
		double result2 = mycal.area(x, y);
		
		System.out.println("정사각형 넓이: "+ result1);
		System.out.println("직사각형 넓이: "+ result2);
	}
}



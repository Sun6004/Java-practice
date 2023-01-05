package chapter04;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {

	
		 
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("가로의 길이는?(단위: m): ");
//		double L = scanner.nextDouble();
//		
//		System.out.print("세로의 길이는?(단위: m): ");
//		double h = scanner.nextDouble();
//		
//		double result;	
//		result = L*h;
//		System.out.print("직사각형의 넓이:"+result);
//		
//		result = (L+h)*2;
//		System.out.println("직사각형 둘레:"+result);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("가로의 길이는? ");
		double L = scanner.nextDouble();
		
		System.out.print("세로의 길이는?");
		double h = scanner.nextDouble();
		
		double result;
		result = L*h;
		System.out.println("직사각형의 넓이"+result);
		
		result = (L*h)*2;
		System.out.println("직사각형의 둘레"+result);
		
		
	}

}

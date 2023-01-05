package chapter04;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("원기둥 밑면의 반지름을 입력.(단위: cm):");
		double r = scanner.nextDouble();
		
		System.out.print("원기둥의 높이를 입력.(단위: cm):");
		double h = scanner.nextDouble();
	
		
		double result = r*r*Math.PI;
		System.out.print("원기둥 밑면의 넓이:" + result + "㎠" +"이고, ");
		double result2 = result*h;
		System.out.println("원기둥의 부피: "+ result2 + "㎠"+"이다.");
	}

}

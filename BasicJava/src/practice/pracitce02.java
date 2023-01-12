package practice;

import java.util.Scanner;

public class pracitce02 {

	public static void main(String[] args) {
		
		int x = 7;
		int y = 15;
		int z = 7;
		double area = ((x+y)*z/2.0);
		System.out.println(area);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("1: ");
		double a = Double.parseDouble(scanner.nextLine());
		System.out.print("2: ");
		double b = Double.parseDouble(scanner.nextLine());
		
		System.out.println("---------------------------------");
		
		if(b != 0.0) {
			System.out.println("결과: "+a/b);
		}else {
			System.out.println("infinty");
		}
			
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = Double.parseDouble(var2 +"."+var3);
		System.out.println(var4);
		
		System.out.print("id: ");
		String name = scanner.nextLine();
		System.out.println("ps: ");
		String ps = scanner.nextLine();
		
		int pas = Integer.parseInt(ps);
		
		if(name.equals("java")){
			if(pas == 12345) {
			System.out.println("suscess");
		}else {
			System.out.println("비번틀림");
		}
		}else {
			System.out.println("아이디 틀림");
		}
	}

}

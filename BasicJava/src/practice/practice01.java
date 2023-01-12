package practice;

import java.util.Scanner;

public class practice01 {

	public static void main(String[] args) {
		//1
		String name ="asd";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("tel:"+ tel1 +"-"+tel2+"-"+tel3);
		
		//2
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("num1: ");
		String n1 = scanner.nextLine();
		
		System.out.print("num2: ");
		String n2 = scanner.nextLine();
		
		int num1 =  Integer.parseInt(n1);
		int num2 =  Integer.parseInt(n2);
		int result = num1 + num2;
		System.out.println(num1+"+"+num2+"="+result);
		
		//3
		System.out.print("name: ");
		String a = scanner.nextLine();
		
		System.out.print("주번: ");
		String a2 = scanner.nextLine();
		
		System.out.print("tel: ");
		String tel4 = scanner.nextLine();
		
		System.out.println("[입력한 내용]");
		System.out.println(a);
		System.out.println(a2);
		System.out.println(tel4);
		
		

	}

}

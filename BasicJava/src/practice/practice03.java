package practice;

import java.util.Scanner;

public class practice03 {

	public static void main(String[] args) {
		//1번문제
		int x = 5;
		int y = 5;
		
		if(x>y) {
			System.out.println(">");
		}else if(x<y) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
		
		//2번문제
		int score = 85;
		
		if(score >= 90) {
			System.out.println("A");
		}else if(score >= 80) {
			System.out.println("B");
		}else if(score>=70){
			System.out.println("c");
		}else if(score>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		//3번문제
		Scanner scan = new Scanner(System.in);
		System.out.print("연도입력: ");
		int year = scan.nextInt();
		
		if((year%4 == 0) && (y%400 ==0)){
			System.out.println("윤년");
		}else if ((year%4 == 0) && (year%100 !=0)) {
			System.out.println("윤년아님");
		}else {
			System.out.println("윤년아님");
		}
		
		//4번문제
		System.out.print("구구단 단수입력: ");
		int n = scan.nextInt();
		
		for(int k=1; k<=9; k++) {
			System.out.println(n+ "x"+ n +"=" + (n*k));
		}
		
		//5번문제
			
		
	}

}

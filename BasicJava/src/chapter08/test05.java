package chapter08;

import java.util.Scanner;

public class test05 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		
		System.out.print("프로그래밍 기초: ");
		int pr = Integer.parseInt(scanner.nextLine());
		
		System.out.print("데이터베이스: ");
		int db = Integer.parseInt(scanner.nextLine());
		
		System.out.print("화면 구현: ");
		int dg = Integer.parseInt(scanner.nextLine());
		
		System.out.print("애플리케이션 구현: ");
		int apk = Integer.parseInt(scanner.nextLine());
		
		System.out.print("머신러닝: ");
		int ml = Integer.parseInt(scanner.nextLine());
		

		int tot = (pr+db+dg+apk+ml);
		System.out.println(tot);
		
		double evr = (double)tot /5;
		System.out.println(evr);
		
			if(evr >= 90) {
				System.out.println("학점: A");
			}else if(evr >=80) {
				System.out.println("학점: B");	
			}else if(evr >=70) {
				System.out.println("학점: C");	
			}else if(evr >=60) {
				System.out.println("학점: D");	
			}else {
				System.out.println("학점: F");
			}				
	}

}

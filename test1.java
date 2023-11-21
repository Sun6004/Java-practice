package test;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a;
		do {
			System.out.printf("a: ");
			a = sc.nextInt();
			if(a <= 0) {
				System.out.println("0보다 큰 수를 입력하시오. ");
			}
		}while(a <= 0);
		
		int b;
		do {
			System.out.printf("b: ");
			b = sc.nextInt();
			if( b > 10) {
				System.out.println("11보다 작은 수를 입력하시오. ");
			}
		}while(b >10);
		
		System.out.println("result: "+ (a-b));
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		while(n1<=0 || n1 >= 10 || n2 <=0 || n2 >= 0 ) {
			System.out.println("0과 10사이를 입력하세요.");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
		}
		System.out.println("result: " +(n1-n2));
	}
}

package chapter08;

import java.util.Random;
import java.util.Scanner;

public class test02 {

	public static void main(String[] args) {
		//for문을 이용해서 1~100까지의 정수중에서 3의배수의 총합
		
		int sum =0;
		for(int i=0; i<=100; i++){
			if(i%3 !=0) {
				continue;
			
			}
			sum +=i;
			System.out.println(sum-1);
		}
		
		
		//2개의 주사위의 합이 5면 멈추는 프로그램
		Random random = new Random();	
			
		while(true) {
				int num1 = random.nextInt(6)+1;
				int num2 = random.nextInt(6)+1;
				System.out.println("눈1: "+ num1 + "눈2: " +num2);
				if ((num1+num2) == 5) {					
					break;
					
				}
			}
		
		for (int x = 1; x<=10; x++) {
			for(int y = 1; y<=10; y++) {
				if((4*x +5*y)==60) {
					System.out.println("(" + x +"," +y+")");
					}
				}			
			}
		
		for(int a=1; a<5; a++) {
			for(int b=1; b<=a; b++) {
				System.out.print("*");
				if (a == b){
				System.out.println();
				}
			}
		}
		
		for(int c = 1; c<5; c++) {
			for(int v=4; v>0; v--) {
				if(v>c) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		boolean bank = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(bank) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");			
			System.out.print("선택> ");
			
			int mnum = Integer.parseInt(scanner.nextLine());
			
			switch (mnum){
				case 1:
					System.out.print("예금액> ");
					balance += Integer.parseInt(scanner.nextLine());
					break;
				
				case 2:
					System.out.print("출금액> ");
					balance -= Integer.parseInt(scanner.nextLine());
					break;
				
				case 3:
					System.out.print("잔고> ");
					System.out.println(balance);
					break;
				case 4:
					bank = false;
					break;			
			}
			
		}
		System.out.println("프로그램 종료");
		
		
	}

}

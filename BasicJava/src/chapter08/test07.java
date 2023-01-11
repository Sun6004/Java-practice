package chapter08;

import java.util.Random;
import java.util.Scanner;

public class test07 {

	public static void main(String[] args) {
		
		Random random = new Random();			
		Scanner Scanner = new Scanner(System.in);
		
		
		int num = random.nextInt(100)+1;
		System.out.println(num);
		
		while(true) {
			System.out.print("1부터 100사이의 정수중 하나를 선택하세요: ");
			int x = Scanner.nextInt();
			
			if(num < x) {
				System.out.println("정답은 더 작은 수 입니다.");
			}else if(num > x) {
				System.out.println("정답은 더 큰 수 입니다.");
			}else {
				break;
			}		
		}			 		
		System.out.println("정답입니다.");
		System.out.println("게임을 종료합니다.");
				
	}

}

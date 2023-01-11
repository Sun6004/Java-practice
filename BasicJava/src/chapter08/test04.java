package chapter08;

import java.util.Scanner;

public class test04 {
	
	public static void main(String[] args) {		
		
		Scanner scanner = new Scanner(System.in);		
		System.out.print("월을 입력하세요(1~12): ");
		int mon = scanner.nextInt();		
		if (mon < 1 || mon > 12){
			System.out.print(mon + "월은 잘못된 입력입니다. ");
			return;
		}
		String season;
		//&& : 연산자와 피연산자 모두가 true일때 true
		if(mon > 2 && mon < 6){
			season = "봄";
		}
		else if (mon > 5 && mon < 9){
			season = "여름";
		}
		else if (mon> 8 && mon < 12){
			season = "가을";
		}
		else{
			season = "겨울";
		}
		System.out.print(mon + "월은" + season + "입니다");				
	}
}
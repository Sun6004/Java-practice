package chapter07;

import java.util.Random;
import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {
		
		// switch문에서 변수는 정수형문자열만 가능 : int,char,string
		int score = 93;

		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다. ");
			System.out.println("등급은 A 입니다. ");
		}
		if (score < 90) {
			System.out.println("점수가 90보다 작습니다. ");
			System.out.println("등급은 B 입니다.");
		}
	
		int score2 = 85;
		
		if(score2>=90) {
			System.out.println("점수가 90보다 큽니다. ");
			System.out.println("등급은 A 입니다. ");
		} else {
			System.out.println("점수가 90보다 작습니다. ");
			System.out.println("등급은 B 입니다.");
		}
		
		
		int score3 = 75;
		
		if(score3>=90) {
			System.out.println("점수가 100~90입니다.");
			System.out.println("등급은 A 입니다.");
		}else if(score3>=80) {
			System.out.println("점수가 80~89 입니다. ");
			System.out.println("등급은 B 입니다.");
		}else if(score3 >=70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C 입니다.");
		}else {
			System.out.println("점수가 70점 미만입니다.");
			System.out.println("등급은 D 입니다.");
		}
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("DB: ");
		int num1 = scanner.nextInt();
		
		System.out.print("전자계산기 구조: ");
		int num2 = scanner.nextInt();
		
		System.out.print("OS: ");
		int num3 = scanner.nextInt();
		
		System.out.print("데이터통신: ");
		int num4 = scanner.nextInt();
		
		System.out.print("소프트웨어공학: ");
		int num5 = scanner.nextInt();
		
		int sum = num1 + num2 + num3 + num4 + num5;
		
		if(num1>=8 == num2>=8  == num3>=8 == num4>=8 == num5>=8 == sum >=60) {
			System.out.println("합격입니다");
		}else {
			
			System.out.println("불합격입니다.");
		}
		
		System.out.println("***점수를 입력해주세요***");
		System.out.print("시험점수는?: ");
		int x = scanner.nextInt();
		
		if(x >= 60 ) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		
	
	}

}

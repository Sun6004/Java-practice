package chapter07;

import java.util.Random;
import java.util.Scanner;

import javax.swing.text.DefaultTextUI;

public class test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//하나의 수를 랜덤으로 뽑는 프로그램
		//Math.random : 0.0~1사이의 정수중에서 하나를 얻음
		Random random = new Random(); //()안에 수 시드 : 똑같은 값 나옴
		
		int r1 = random.nextInt(6)+1; //()안에 총 개수
		int r2 = random.nextInt(6)+1;
		int r3 = random.nextInt(6)+1;
		int r4 = random.nextInt(6)+1;
		int r5 = random.nextInt(6)+1;
		int r6 = random.nextInt(6)+1;
		int r7 = random.nextInt(6)+1;
		int r8 = random.nextInt(6)+1;
		                    
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		System.out.println(r6);
		System.out.println(r7);
		System.out.println(r8);
		
		
		//if를 활용한 주사위 번호뽑기
		int num = random.nextInt(6)+1;
		int num2 = random.nextInt(6)+1;

		
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		}
		else if(num==2) {
			System.out.println("2번이 나왔습니다.");
		}
		else if(num==3) {
			System.out.println("3번이 나왔습니다.");
		}
		else if(num==4) {
			System.out.println("4번이 나왔습니다.");
		}
		else if(num==5) {
			System.out.println("5번이 나왔습니다.");
		}
		else {
			System.out.println("6번이 나왔습니다.");
		}
		
		//switch를 활용한 주사위 번호뽑기
		switch(num2) {
			case 1:
				System.out.println("1번이 나왔습니다.");
				break;
			case 2:
				System.out.println("2번이 나왔습니다.");
				break;
			case 3:
				System.out.println("3번이 나왔습니다.");
				break;
			case 4:
				System.out.println("4번이 나왔습니다.");
				break;
			case 5:
				System.out.println("5번이 나왔습니다.");
				break;
			default:
				System.out.println("6번이 나왔습니다.");
				break;
		}
		
		
		//break문이 없는 switch
		int time=random.nextInt(4)+8;
		System.out.println("[현재시각: " + time + "시]");
		
		switch (time) {
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:
			System.out.println("외근을 나갑니다.");
		}
		
		//char 타입의 switch문
		
		
		char grade = 'B';
		
		switch(grade) {
			case 'A':
			case 'a':
				System.out.println("우수 회원입니다.");
				break;
			case 'B':
			case 'b':
				System.out.println("일반 회원입니다.");
				break;
				default:
					System.out.println("손님입니다.");
		}
		
		//string 타입의 switch문
		
		String position = "과장";
		
		switch (position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");
			break;
		}
		
		

	}                        

}

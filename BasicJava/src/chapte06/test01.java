package chapte06;

import java.util.Scanner;

import javafx.scene.transform.Scale;

public class test01 {

	public static void main(String[] args) {

		// int sum = 0;
		// sum = sum+=1; -> sum +=1; -> sum++;
		int a = 10;
		int z = a++;
		int y = ++a;
		
		System.out.println();

		// 삼항 연산자 : 조건식 ? 값/연산식 : 값/연산식
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은" + grade + "등급입니다.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수학점수 : ");
		int score1 = scanner.nextInt();
		System.out.print("영어점수 : ");
		int score2 = scanner.nextInt();
		
		System.out.println("수학점수");
		System.out.println((score1 >= 90) ? "A" : (score1 >= 80) ? "B" : (score1 >= 70 ) ? "C" : "D"  );
		System.out.println("영어점수");
		System.out.println((score2 >= 90) ? "A" : (score2 >= 80) ? "B" : (score2 >= 70 ) ? "C" : "D" );	

		
		int x = 10;
		int y2 = 20;
		int z2 = (++x) + (y2--);
		System.out.println(z2);

		// 4,6,8,9,10,11 문제풀기
		int pen = 534;
		int stu = 30;

		// 학생 1명이 가지는 펜 개수
		int penPerStu = pen / stu;
		System.out.println(penPerStu);

		// 남은 펜 개수
		int penLeft = pen % stu;
		System.out.println(penLeft);

		//십의자리 이하 숫자 버리기
		int value = 356;
		System.out.println(value / 100 * 100);
		System.out.println(value - value % 100);

		
		double top = 5;
		double bott = 10;
		double h = 7;
		double area = ((top+bott)/2);
		
		System.out.println(area);
		

		Scanner scanner3 = new Scanner(System.in);
		
		System.out.print("첫번째 수: ");
		//double num1 = Double.parseDouble(scanner.nextLine());
		double num1 = scanner3.nextDouble();
		
		System.out.print("두번째 수: ");
		//double num2 = Double.parseDouble(scanner.nextLine());
		double num2 = scanner3.nextDouble();
		 
		System.out.println("---------------------");
		
		if(num2 != 0.0) {
			System.out.println("결과: " +(num1/num2));
		}
		else {
			System.out.println("무한대");
		}
		//삼황연산자 사용
		System.out.println((num2 == 0.0 ) ? "무한대" : "결과: " + (num1/num2));

		
		// 문자열-> 정수형 객체 : parseInt, 문자열->double형 객체 : praseDouble
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;

		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의넓이:" + var4);
		

		Scanner scanner2 = new Scanner(System.in);
		
		System.out.print("아이디: ");
		String name = scanner2.nextLine();
		
		System.out.print("패스워드: ");
		String strPassword = scanner2.nextLine();
		
		//문자열을 정수형객체로 변환
		int password = Integer.parseInt(strPassword);
		
		
		
		//equals : 내용을 비교
		if(name.equals("java")) {
			
			if(password == 12345) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("로그인 실패: 패스워드 틀림");
			}	
		}
		else {
			System.out.println("로그인 실패: 아이디가 존재하지 않음");
		}
				

	}

}

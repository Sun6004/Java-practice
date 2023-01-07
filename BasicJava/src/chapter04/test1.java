package chapter04;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
//		//system.in/ouy.read(); 표준 입출력장치
//		//printf = print + format : 형식에맞게 출력 %d:정수, %f:실수, %s:문자열
//		//("%d , %d",1000000) = 1,000,000 ,자동으로 찍어줌 
//		
//		String name = "감자바";
//		int age = 25;
//		Scanner scanner = new Scanner(System.in);
//		
//		String tel1 = "010", tel2="123", tel3="4567";
//		
//		System.out.println("이름: "+ name);
//		System.out.println("나이: "+ age);
//		System.out.println("전화: "+ tel1 + "-" + tel2+"-" + tel3);

		
		//Scanner 의 입력 메소드들은 대부분 공백과 개행(' ', '\t', '\r', '\n' 등등..)을 기준
		//System.in 은 사용자로부터 입력을 받기 위한 입력 스트림
//		Scanner scanner = new Scanner(System.in);
//		//scanner.next/nextline(문자열), next.int(정수)
//		
//
//		int num1 = 0;
//		int num2 = 0;
//		
//		num1 = scanner.nextInt();
//		System.out.println("첫번째 수: " + num1);
//		String strNum1 = scanner.nextLine();
//		
//		
//		num2 = scanner.nextInt();
//		System.out.println("두번째 수: " + num2);
//		String strNum2 = scanner.nextLine();
//
//
//		int result = num1 + num2;
//		System.out.println("덧셈 결과" + result);
		

		
//		Scanner sc = new Scanner(System.in);
//
//		//변수선언과 0으로 초기화
//		int n1 = 0;
//		int n2 = 0;
//		int result = 0;
//
//		System.out.print("n1 입력 : ");//여기에 입력받기, 입력받기위해 줄봐꿈x
//		n1 = sc.nextInt(); //사용자로부터 입력받기위해 scanner사용 정수타입이니 nextInt
//		System.out.println("n1의 입력받은 값: " + n1);
//
//		System.out.println("n2입력 : ");
//		n2 = sc.nextInt();
//		System.out.println("n2의 입력받은 값: " + n2);
//
//		result = n1 + n2;
//		System.out.println("result: " + result);
		

	Scanner scanner = new Scanner(System.in);
	String inputData1, inputData2, inputData3; //문자열 사용을 위해 String

	System.out.println("[필수 정보 입력]");
	System.out.print("1. 이름: ");
	
	//문자열로 입력받고싶으면 next()/nextLine(), 정수(int)로 입력받고싶으면 nextInt()
	inputData1 = scanner.nextLine();
	
	System.out.print("2.주민번호 앞 6자리: ");
	inputData2 = scanner.nextLine();
	System.out.print("전화번호: ");
	inputData3 = scanner.nextLine();

	System.out.printf("입력한 내용: \n%s \n%s \n%s", inputData1, inputData2, inputData3);

	}

}

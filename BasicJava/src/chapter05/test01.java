package chapter05;

public class test01 {
	// 연산자
	public static void main(String[] args) {

		// 부호연산자
		{
			int x = -100;
			int result1 = +x;
			int result2 = -x;
			System.out.println("result1=" + result1);
			System.out.println("result2=" + result2);

			byte b = 100;
			// byte result3 = -b;
			// 부호연산시 int값으로 봐뀌므로 byte 사용불가
			int result3 = -b;
			System.out.println("result3=" + result3);
		}

		// 논리부정 연산자(!)

		// 산술연산자 % : 왼쪽을 오른쪽으로 나눈 "나머지" ex)10/3 = 3.3.. , 10%3 = 1
		{
			int v1 = 5;
			int v2 = 2;

			int result1 = v1 + v2;
			System.out.println("result1=" + result1);

			int result2 = v1 - v2;
			System.out.println("result2=" + result2);

			int result3 = v1 * v2;
			System.out.println("result3=" + result3);

			// int는 소수점 버림
			int result4 = v1 / v2;
			System.out.println("result4=" + result4);

			int result5 = v1 % v2;
			System.out.println("result5=" + result5);

			// 소수점 받음
			double result6 = (double) v1 / v2;
			System.out.println("result6=" + result6);
		}
		// Concat : 문자열 결합

		// 문자열 결합 연산자
		String str1 = "jdk" + 6.0;
		String str2 = str1 + "특징";
		String str3 = "jdk" + 3 + 3.0; // 문자열이기때문에 33.0
		String str4 = 3.0 + "jdk";

		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

		// 비교연산자
		{
			int num1 = 10;
			int num2 = 20;
			System.out.println(num1 == num2);
			System.out.println(num1 != num2);
			System.out.println(num1 <= num2);

			// 아스키코드의 값을 비교
			char char1 = '가';
			char char2 = '나';
			System.out.println(char1 <= char2);

			// 문자열은 비교불가
			// String str1 = "가";
			// String str2 = "나";
			// System.out.println(str1 <= str2);

			int v2 = 1;
			double v3 = 1.0;
			System.out.println(v2 == v3);// 자동으로 v2를 더블타입 1.0으로 봐꿔서 비교

			// double와 float의 0.1과 가장가까운 근사치가 다르기때문에 false
			double v4 = 0.1;
			float v5 = 0.1f;
			System.out.println(v4 == v5);// ((float)v4 == v5)사용시 true / v5를 double를 맞추면 강제로 .000을붙여 false
		}

		// 비교연산자2
		int num1 = 10;
		int num2 = 10;

		char char1 = 'A';
		char char2 = 'B';

		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		boolean result4 = (char1 < char2);

		System.out.println("result1= " + result1);
		System.out.println("result2= " + result2);
		System.out.println("result3= " + result3);
		System.out.println("result4= " + result4);
		
		
		//비교연산자3
		int v2 = 1;
		double v3 = 1.0;

		System.out.println(v2 == v3);

		double v4 = 0.1;
		float v5 = 0.1f;

		System.out.println(v4 == v5);
		System.out.println((float) v4 == v5);
		

		// 논리연산자
		int charCode = 'A';

		if ((charCode >= 65) & (charCode <= 90)) {
			System.out.println("대문자");
		}

		if ((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자");
		}
		if (!(charCode >= 48) && (charCode <= 57)) {
			System.out.println("0~9숫자");
		}

		int value = 6;

		if ((value % 2 == 0) | (value % 3 <= 0)) {
			System.out.println("2 또는 3의 배수");
		}

		if ((value % 2 == 0) && (value % 3 <= 0)) {
			System.out.println("2 또는 3의 배수");
		}

		// 대입연산자 : (sum = sum+10;) = (sum+= 10;)
		int result = 0;
		result += 10;
		System.out.println("result= " + result);

		result -= 5;
		System.out.println("result= " + result);

		result *= 3;
		System.out.println("result= " + result);

		result /= 5;
		System.out.println("result= " + result);

		result %= 3;
		System.out.println("result= " + result);

		
		//삼황 연산자 : (조건식) ? 값A : 값B /조건식이true 일때 값 A출력, false일때 값 B출력	
//		int score = 95;
//		char grade;
//		
//		if(score>90) {
//			grade = 'A';
//		}
//		
//		else {
//			grade = 'B';
//		}
//		
//		System.out.println("grade = " + grade);
		int score = 95;
		char grade = (score > 90) ? 'A' : 'B';

		System.out.println(grade);
		
		// 삼황 연산자2
		int score2 = 80;

		char grade2 = (score2 >= 90) ? 'A' : ((score2 >= 80) ? 'B' : 'c');
		System.out.println(score2 + "점은 " + grade2 + "등급입니다.");
		
		
		//534자루의 펜을 30명의 학생들에게 나누어줄때
		int pen = 534;
		int stu = 30;
		
		//학생 1명이 가지는 펜 개수
		int penPerStu = pen / stu;
		System.out.println(penPerStu);
		
		//남은 펜 개수
		int penLeft = pen%stu;
		System.out.println(penLeft);

	}

}

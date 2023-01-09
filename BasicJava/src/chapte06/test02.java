package chapte06;

import java.util.Scanner;

public class test02 {
	

	public static void main(String[] args) {
			
		
		Scanner scanner = new Scanner(System.in);		
		System.out.print("첫번째 숫자를 입력하시오: ");
		int num1 = scanner.nextInt();
				
		System.out.print("두번째 숫자를 입력하시오: ");
		int num2 = scanner.nextInt();
		
		int a = ((num1+num2) + Math.abs(num1-num2)) / 2;
		int b = ((num1+num2) - Math.abs(num1-num2)) / 2;
		int c = a / b;
		int d = a % b;
		
		System.out.println("큰 수를 작은 수로 나눈 몫은" + c + " 이고, 나머지는" + d + " 이다.");

		

		
	}

}

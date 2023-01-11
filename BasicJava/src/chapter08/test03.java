package chapter08;

import java.util.Scanner;

public class test03 {

	public static void main(String[] args) {
		//
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삼각형의 첫번째 변의 길이: ");
		int x = scanner.nextInt();
		System.out.print("삼각형의 두번째 변의 길이: ");
		int y = scanner.nextInt();
		System.out.print("삼각형의 세번째 변의 길이: ");
		int z = scanner.nextInt();
		
		if((x+y)<z || (x+z)<y || (y+z)<x) {
			System.out.println("삼각형을 만들 수 없습니다.");
		}else {
			System.out.println("삼각형을 만들 수 있습니다");
		}
		
	}

}

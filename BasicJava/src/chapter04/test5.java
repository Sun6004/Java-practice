package chapter04;

import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		
		int coin500, coin100, coin50, coin10;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("500원 짜리 동전의 갯수: ");
		coin500 = scanner.nextInt();
		System.out.print("100원 짜리 동전의 갯수: ");
		coin100 = scanner.nextInt();
		System.out.print("50원 짜리 동전의 갯수: ");
		coin50 = scanner.nextInt();
		System.out.print("10원 짜리 동전의 갯수: ");
		coin10 = scanner.nextInt();
		
		int total = (coin500 *500)+(coin100 *100)+(coin50 *50)+(coin10 *10);
		System.out.print("저금통 안의 동전의 총 액수: " + total);
		



	}

}

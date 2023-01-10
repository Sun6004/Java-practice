package chapter07;

import java.util.Iterator;
import java.util.Random;

public class test03 {

	public static void main(String[] args) {
		// 반복문
		// for(초기화식; 조건식; 증감식)
		Random random = new Random();
		for (int i = 1; i <= 8; i++) {
			System.out.println(i + "번째 값" + (random.nextInt(6) + 1));
		}
		// 1부터 100까지 합을 출력
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1~100의 합" + sum);

		// 2
		int sum2 = 0;

		int i2 = 0;
		for (i2 = 1; i2 <= 100; i2++) {
			sum2 += i2;
		}
		System.out.println("1~" + (i2 - 1) + "합: " + sum2);

		// float타입 카운터변수
		for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
			System.out.println(x);
		}

		// 중첩for문을 이용한 구구단 출력
		for (int m = 2; m <= 9; m++) {
			System.out.println("***" + m + "단 ***");
			for (int n = 1; n <= 9; n++) {
				System.out.println(m + "x" + n + "=" + (m * n));
			}
		
		}
		
		//while로 1부터 10까지 출력
		int a = 1;
		while (a<=10) {
			System.out.println(a);
			a++;
		}

	}

}

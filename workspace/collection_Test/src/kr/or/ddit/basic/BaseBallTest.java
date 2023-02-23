package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * 문제) Set을 이용하여 숫자 야구게임 프로그램을 작성하시오.
 * (컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9사이의 값 3개)
 * (스트라이크는 S, 볼은 B로 나타낸다.)
 * 예) 컴퓨터의 난수 ==> 9, 5, 7
 * 실행에서) 숫자입력 -> 3, 5, 6
 * 결과) 3 5 6 ==> 1S 0B
 * 숫자입력 -> 7 8 9
 * 결과) 7 8 9 ==>0S 2B
 * 숫자입력 -> 9 7 5
 * 결과) 9 7 5 ==>1S 2B
 * 숫자입력) 9 5 7 
 * 9 5 7 => 3S 0B
 * 
 * 축하합니다 당신읜 n번째 안에 맞췄습니다.
 */

public class BaseBallTest {
	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<>();
			while(set.size()<3) {
			set.add(r.nextInt(9)+1);
			}
		//System.out.println(set);
		ArrayList<Integer> list = new ArrayList<>(set);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		int n1;
		int n2;
		int n3;
		
		System.out.println("야구게임");
		System.out.print("숫자3개 입력: ");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		
		
		
		while(true) {
		int s = 0;
		int b = 0;
		int count = 0;
		
		int[] player = new int[] {n1, n2, n3};
	
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < player.length; j++) {				
				if(list.get(i) == player[j]) {
					if(i==j) {
						s++;
					}else{b++;}
				}
			}
		} count ++;
		for(Integer i : player) {
			System.out.println(i + " ");
		}
		System.out.println(s+ "S" + b+"B");
		if(s == 3) {
			System.out.println("축하합니다.");
			System.out.println("당신은"+count+"번 만에 맞췄습니다.");
			
		}
		break;
	
	}
		sc.close();
	}
}

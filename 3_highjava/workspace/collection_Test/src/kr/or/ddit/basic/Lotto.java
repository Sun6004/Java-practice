package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("=======================");
		System.out.println("Lotto 프로그램");
		System.out.println("-------------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=======================");
		System.out.print("메뉴선택: ");
		
		Set lottoNum = new HashSet<>();
		int num;
		
		while(lottoNum.size() !=6) {
			num = r.nextInt(45)+1;
			lottoNum.add(num);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>(lottoNum);
		Collections.sort(arr);
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("로또 구입 시작");
			System.out.println("1000원에 로또번호 하나입니다.");
			System.out.print("금액입력");
			int pay = sc.nextInt();
			int lotto = pay/1000;
			if(pay > 100000) {
				System.out.println("입력 금액이 너무 많습니다. 로또 구입 실패!");
				break;
			}else if(lotto<100){	
				for (int i = 1; i < lotto; i++) {
					for (Integer list : arr) {
						System.out.println(i+"번 로또"+list+ "");
					}	
				}		
			}
			break;
		case 2:
			System.out.println("감사합니다.");
			System.exit(0);
			break;

		default:
			break;
		}
		

		


	}
}

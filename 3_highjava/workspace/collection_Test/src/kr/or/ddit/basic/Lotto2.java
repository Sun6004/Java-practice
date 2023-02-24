package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto2 {
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Lotto2().lottoStart();
	}
	public void lottoStart() {
		while(true) {
			int choice = diplayMenu();
			switch (choice) {
			case 1:
				buyLotto();
				break;
			case 2:
				System.out.println("감사합니다.");
				return;
				//System.exit(0); 

			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				System.out.println("1 또는 2번을 입력해 주세요");
				break;
			}
		}
	}
	
	private int diplayMenu() {
		System.out.println();
		System.out.println("=======================");
		System.out.println("Lotto 프로그램");
		System.out.println("-------------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=======================");
		System.out.print("메뉴선택: ");
		
		return sc.nextInt();
		
	}
	//로또를 판매를 처리하는 메소드
	private void buyLotto() {
		System.out.println();
		System.out.println("로또 구입 시작");
		System.out.println("1000원에 로또번호 하나입니다.");
		System.out.print("금액입력");
		int money = sc.nextInt();
		
		System.out.println();
		if(money < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또 구입 실패!");
		}else if(money >= 100900) {
			System.out.println("입력 금액이 너무 많습니다. 로또 구입 실패!");
			return;
		}
		
		//로또번호 생성
		HashSet<Integer> lottoSet = new HashSet<>();
		Random r = new Random();
		//구매할 수량 계산
		int count  = money / 1000;
		
		for (int i = 1; i < count+1; i++) {
			while(lottoSet.size() < 6) {
				lottoSet.add(r.nextInt(45)+1);
			}
			//랜덤으로 생성한 번호를 정렬
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
			Collections.sort(lottoList);
			
			System.out.print("로또번호 "+ i +": ");
			for (int j = 0; j < lottoList.size(); j++) {
				if(j>0) System.out.print(", ");
				System.out.print(lottoList.get(j));
			}
			System.out.println();
			lottoSet.clear(); //비워주지 않으면 for문을 실행할때 이미 값이있어서 while을 실행하지 않음
		}
		System.out.println("받은 금액은 "+money + "원이고 거스름돈은"+(money%1000)+"원 입니다.");

	}
}

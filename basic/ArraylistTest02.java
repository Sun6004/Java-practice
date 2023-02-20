package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraylistTest02 {
	public static void main(String[] args) {
		
		//문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에 이 ArrayList에 저장된 이름들 중에
		// '김'씨 성의 이름을 찾아 모두 출력하시오.
		// 단 입력은 Scanner를 이용한다.
		
		Scanner sc = new Scanner(System.in);
		ArrayList arr = new ArrayList<>();
		
		System.out.println("사람이름 입력:");
		arr.add(sc.nextLine());
		arr.add(sc.nextLine());
		arr.add(sc.nextLine());
		arr.add(sc.nextLine());
		arr.add(sc.nextLine());
		
		for (String str : arr) {
			System.out.println(str.contains("김"));
		}
		
	}
}

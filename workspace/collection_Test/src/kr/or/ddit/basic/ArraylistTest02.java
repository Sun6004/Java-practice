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
		
		System.out.print("사람이름 입력:");
		for (int i = 1; i < 6; i++) {
			System.out.println(i+"번째 사람이름");
			String name = sc.next();
			arr.add(name);
		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들..");
		
		for (int i = 0; i <arr.size(); i++) {
			if(((String) arr.get(i)).charAt(0) == '김' ) {
				System.out.println(arr.get(i));
			}
		}
		
		//2번째 방법 subSting사용
		ArrayList arr2 = new ArrayList<>();
		System.out.print("사람이름 입력:");
		for (int i = 1; i < 6; i++) {
			System.out.println(i+"번째 사람이름");
			String name = sc.next();
			arr2.add(name);
		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들..");
		
		for (int i = 0; i <arr2.size(); i++) {
			if(((String) arr2.get(i)).substring(0,1).equals("김")) {
				System.out.println(arr2.get(i));
			}
		}
		//3번째 방법 indexof
		ArrayList arr3 = new ArrayList<>();
		System.out.print("사람이름 입력:");
		for (int i = 1; i < 6; i++) {
			System.out.println(i+"번째 사람이름");
			String name = sc.next();
			arr3.add(name);
		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들..");
		
		for (int i = 0; i <arr3.size(); i++) {
			if(((String) arr3.get(i)).indexOf("김")==0) {
				System.out.println(arr2.get(i));
			}
		}
		//4번째 방법 startsWith
		ArrayList arr4 = new ArrayList<>();
		System.out.print("사람이름 입력:");
		for (int i = 1; i < 6; i++) {
			System.out.println(i+"번째 사람이름");
			String name = sc.next();
			arr4.add(name);
		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들..");
		
		for (int i = 0; i <arr4.size(); i++) {
			if(((String) arr4.get(i)).startsWith("김")) {
				System.out.println(arr4.get(i));
			}
		}
		
		//contains 는 "김"이 포함된 모든결과를 true로 반환하기때문에 정답이아님
		for (int i = 0; i <arr4.size(); i++) {
			if(((String) arr4.get(i)).contains("김")) {
				System.out.println(arr4.get(i));
			}
		}
	sc.close();
	}
	
}

package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraylistTest03 {
	public static void main(String[] args) {

		// 문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
		// (단, 각 별명의 길이는 모두 다르게 입력한다.)

		Scanner sc = new Scanner(System.in);
//		ArrayList<Object> arr = new ArrayList<>();
//		
//		System.out.println("별명을 입력하세요.");
//		for (int i = 1; i < 6; i++) {
//			System.out.print(i+"번째 사람");
//			String nName = sc.next();
//			arr.add(nName); 
//		}
//		int maxLangth = 0;
//		String longSt = "";
//		for(Object str : arr) {
//			if(((String) str).length()> maxLangth) {
//				maxLangth = ((String) str).length();
//				Object longestStr = str;
//			}
//		}
//		
//		System.out.println(maxLangth);
		//

		ArrayList<String> arr2 = new ArrayList<>();
		System.out.println("별명을 입력하세요.");
		for (int i = 1; i < 6; i++) {
			System.out.print(i + "번째 별명");
			String id = sc.next();
			arr2.add(id);
		}
		System.out.println();

		// 제일 긴 별명의 변수에 list의 첫번째 데이터로 초기화
		String maxAlias = arr2.get(0);

		for (int i = 1; i < arr2.size(); i++) {
			if (maxAlias.length() < arr2.get(i).length()) {
				maxAlias = arr2.get(i);
			}
		}
		System.out.println(maxAlias);

		// 문제2)5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
		// (단, 각 별명의 길이가 같을 수 있다.)
		ArrayList<String> arr = new ArrayList<>();
		System.out.println("별명을 입력하세요.");
		for (int i = 1; i < 6; i++) {
			System.out.print(i + "번째 별명");
			String id = sc.next();
			arr.add(id);
		}
		System.out.println();
		
		//제일 긴 별명의 길이가 저장될 변수를 선언
		int maxLang = arr.get(0).length();
		
		for (int i = 1; i < arr.size(); i++) {
			if(maxLang < arr.get(i).length()) {
				maxLang = arr.get(i).length();
			}
		}
		System.out.println("가장 긴 별명들");
		for (String id : arr) {
			if(id.length() == maxLang) {
				System.out.println(id);
			}
		}
		sc.close();
	}
}

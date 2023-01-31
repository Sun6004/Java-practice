package Exam;

import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("철수: ");
		String cs = scanner.next();
		System.out.print("영희: ");
		String yh = scanner.next();
		String result = "";
		
		if (cs.equals(yh)) {
			result = "무승부";
		}else if(cs.equals("가위")&& yh.equals("바위")||
				cs.equals("바위")&& yh.equals("보")||
				cs.equals("보")&& yh.equals("가위")) {		
			result = "영희승리";
		}else {
			result = "철수승리";
		}
		System.out.println("결과");
		System.out.println(result);
		scanner.close();
	}
}

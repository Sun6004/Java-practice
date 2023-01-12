package chapter09;

import java.util.Scanner;


public class test01 {

	public static void main(String[] args) {
		// 시험 나옴!!
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위 바위 보 게임");
		
            System.out.print("철수: ");
            String x = scanner.nextLine();
            
            System.out.print("영희: ");
            String y = scanner.nextLine();
            String result = " ";
		
		if(x.equals(y)) {
			result = "비겼습니다!";
		}else if(x.equals("가위") && y.equals("바위")
				|| x.equals("바위")&& y.equals("보")
				|| x.equals("보") && y.equals("가위")){
			System.out.println("영희 승리!");			
		}else {
			result = "철수 승리!";
		}	System.out.println("결과: "+ result )
		
		;
		System.out.println("가위 바위 보 게임");
		
		System.out.print("철수: ");
		String i = scanner.nextLine();
		System.out.print("영희: ");
		String j = scanner.nextLine();
		String result2 = " ";
		
		if(i.equals(j)) {
			result2 = "무승부!";
		}else if(i.equals("가위") && j.equals("보")
				|| i.equals("바위") && j.equals("가위")
				|| i.equals("보") && j.equals("가위")) {
			System.out.println("철수 승리!");
		}else {
			result2 = "영희 승리!";
		}System.out.println("결과: " + result2);
		scanner.close();
	}
	
}

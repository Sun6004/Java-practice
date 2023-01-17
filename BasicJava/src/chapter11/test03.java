package chapter11;

import java.util.Random;
import java.util.Scanner;

public class test03 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Random ran = new Random();
		String result = "";
		String[] array= {"가위","바위","보"};
		int ai = ran.nextInt(3);
		
		
	   System.out.print("가위 바위 보를 입력하세요: ");
       String player = sc.nextLine();
            		
       System.out.println("인공지능 컴퓨터:" +array[ai]);
       
       if(player.equals(array[ai])) {
			result = "무승부!";
		}else if(player.equals("가위") && array[ai].equals("보")
				|| player.equals("바위") && array[ai].equals("가위")
				|| player.equals("보") && array[ai].equals("바위")) {
			result = "게이머승리";
		}else {
			result = "컴퓨터 승리";
		}System.out.println("결과: " + result);  
		
		
	
	}
}

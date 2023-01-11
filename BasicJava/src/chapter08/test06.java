package chapter08;

import java.util.Scanner;

public class test06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("가위 바위 보 게임");
		while (true) {
            System.out.print("철수: ");
            String x = scanner.nextLine();
            
            System.out.print("영희: ");
            String y = scanner.nextLine();
            
            if (x.equals("가위")) {
                if (y.equals("바위")) {
                    System.out.println("영희 승리!");              
                }else if (y.equals("가위")) {         
                    System.out.println("비겼습니다.");              
            }else if (y.equals("보")) {
                    System.out.println("철수 승리!");
                }
            
            } else if (x.equals("바위")) {
                if (y.equals("가위")) {
                    System.out.println("철수 승리!");
                    return;
               
                } else if (y.equals("바위")) {
                    System.out.println("비겼습니다.");
                } else if (y.equals("보")) {
                    System.out.println("영희 승리!");
                }
            }else if (x.equals("보")) {
                if (y.equals("가위")) {
                    System.out.println("영희 승리!");
                } else if (y.equals("바위")) {
                    System.out.println("철수 승리!");
                    return;
                } else if (y.equals("보")) {
                    System.out.println("비겼습니다.");
                }    
		}
	}
	}
}



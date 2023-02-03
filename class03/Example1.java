package class03;

import java.util.Scanner;

public class Example1 {
	private static final String Scanner = null;

	public static void main(String[] args) {
		boolean result = true;
					
		
			while (result) {
				try {
					Scanner Scanner = new Scanner(System.in);
					
					System.out.print("어떤 수를 나누겠습니까?: ");
					int x = Integer.parseInt(Scanner.nextLine());
					System.out.print("어떤 수로 나누겠습니까?: ");
					int y = Integer.parseInt(Scanner.nextLine());
					int result1 = x/y;
					
					System.out.println(x+"/"+y +"="+result1 );
					break;
				}catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("0오로 나눌 수 없습니다. 다시 입력하세요.");
				}
				// scanner 리소스 반납하는법을 잘 모르겠습니다
				//finally {
					//if(scanner != null) {
					//	scanner.close();
					//} 
				//}	
			}
	}
}
package chapter24;

import java.util.Scanner;

public class Example1 {
	private static final String Scanner = null;

	public static void main(String[] args) {
					
	Scanner Scanner = new Scanner(System.in);
		while (true) {
			try {				
				System.out.print("어떤 수를 나누겠습니까?: ");
				int x = Integer.parseInt(Scanner.nextLine());
				//Scanner.nextInt();사용시 : 공백이나 엔터까지 글자로 받아서 리턴해줌
				System.out.print("어떤 수로 나누겠습니까?: ");
				int y = Integer.parseInt(Scanner.nextLine());
				int result1 = x/y;		
				System.out.println(x+"/"+y +"="+result1 );
				break;
			}catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}catch (Exception e) {
				System.out.println("0오로 나눌 수 없습니다. 다시 입력하세요.");
			}
				
		}
		Scanner.close();
	}
}

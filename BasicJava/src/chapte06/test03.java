package chapte06;

import java.util.Scanner;

public class test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수도입니까?(수도:1, 수도아님:0): ");
		int x = scanner.nextInt();
		
		System.out.print("총 인구는?(단위:만 ): ");
		int p = scanner.nextInt();
		
		
		System.out.print("연소득이 1억 이상인 인구는?(단위: 만): ");
		int z = scanner.nextInt();
		
		System.out.println((x < 1) ? "메트로폴리스가 아닙니다" : (p < 100) ? "메트로폴리스가 아닙니다" : 
			(z > 50) ? "이 도시는 메트로폴리스 입니다" : "메트로폴리스가 아닙니다." );
	
		
	}

}

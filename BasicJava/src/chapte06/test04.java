package chapte06;

import java.util.Scanner;

public class test04 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("윤년인지를 확인할 연도를 입력하세요: ");
		int y = scanner.nextInt();
		
		System.out.println(!(y % 4 == 0) ? +y+"년은 윤년이 아닙니다." :
			(y % 100 == 0) ? +y+ "년은 윤년이 아닙니다." :
				(y % 400 == 0) ?  +y+"년은 윤년이 아닙니다." : +y+ "년은윤년입니다.");

	}

}

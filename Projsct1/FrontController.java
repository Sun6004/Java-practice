package Projsct1;

import java.util.Scanner;

//Spring Framework 에서는 DispatcherServlet이라는 클래스로 표현
//모든 컨트롤러를 관리
public class FrontController {
	private MemoController memoController = new MemoController();
	private Scanner scanner = new Scanner(System.in);
	
	//처음 실행하면 호출
	public void process() throws Exception {
		while(true) {
			System.out.println("메모 관리 프로그램");
			System.out.println("-----------------------------------");
			System.out.println("1.목록|2.상세|3.등록|4.수정|5.삭제|0.종료");
			System.out.println("-----------------------------------");
			System.out.print("메뉴 선택> ");
			int selectMenu = Integer.parseInt(scanner.nextLine());
			
			switch (selectMenu) {
			case 1:
				memoController.selectMemos("");
				break;
			case 2:
			
			case 3:
				memoController.insertMemo(scanner);
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(selectMenu);
			default :
				break;
		}
		}
	}
}

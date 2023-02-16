package memoProject;

import java.util.List;
import java.util.Scanner;

public class FrontController {
	private static FrontController instance = new FrontController();
	private FrontController() {
		
	}
	public static FrontController getInstance() {
		return instance;
	}
	private MemoController controller = MemoController.getInstance();
	private MemoView view = MemoView.getInstance();
	private Scanner scanner = new Scanner(System.in);
	public void process() throws Exception{
		view.welcome();
		while(true) {
			int menu = view.mainMenu(scanner);
			switch (menu) {
			case 1:
				List<memoVO> memos = controller.selectMemos();
				view.selectMemos(memos);
				break;
			case 2:
				memoVO myMemo = view.insertMemo(scanner);
				if(myMemo != null) {
					int insertMemo = controller.insertMemo(myMemo);
					view.insertResult(insertMemo);
				}
				break;
			case 3:
				memoVO uMemo = view.updateMemo(scanner);
				if(uMemo != null) {
					int updateMemo = controller.updateMemo(uMemo);
					view.updateResult(updateMemo);
				}
				break;
			case 4:
				int deleteNo = view.deleteMemo(scanner);
				int deleteMemo = controller.deleteMemo(deleteNo);
				view.deleteResult(deleteMemo);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	
}

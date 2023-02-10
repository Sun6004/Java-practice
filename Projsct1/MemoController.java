package Projsct1;

import java.util.List;
import java.util.Scanner;

public class MemoController {
	private MemoService service = new MemoService();
	private MemoView view = new MemoView();
	
	public void selectMemos(String searchWord) throws Exception {
		List<MemoVO> list = service.selectMemos(searchWord);
		view.printMemos(list);
	}
	public MemoVO selectMemo(int searchNo) {
		return service.selectMemo(searchNo);
	}
	public void insertMemo(Scanner scanner) throws Exception {
		MemoVO vo = view.insertInputMemo(scanner);
		int insertMemo = service.insertMemo(vo);
		view.insertResult(insertMemo);
	}
	public int updateMemo(MemoVO vo) {
		return service.updateMemo(vo);
	}
	public int deleteMemo(int deleteNo) {
		return service.deleteMemo(deleteNo);
	}
}

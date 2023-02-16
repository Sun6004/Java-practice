package memoProject;

import java.util.List;

public class MemoController {
	private static MemoController instance = new MemoController();
	private MemoController() {
		
	}
	public static MemoController getInstance() {
		return instance;
	}
	
	private MemoService service = MemoService.getInstance();
	public List<memoVO> selectMemos() throws Exception{
		return service.selevMemos();
	}
	public memoVO selecMemo(int searchNo)throws Exception{
		return service.selectMemo(searchNo);
	}
	public int insertMemo(memoVO vo)throws Exception{
		return service.insertMemo(vo);
	}
	public int updateMemo(memoVO vo)throws Exception{
		return service.updateMemo(vo);
	}
	public int deleteMemo(int deletNo)throws Exception{
		return service.deleteMemo(deletNo);
	}
	
	
}

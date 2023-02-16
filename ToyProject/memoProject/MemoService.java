package memoProject;

import java.util.List;

public class MemoService {
	private static MemoService instance = new MemoService();
	private MemoService() {
	}
	
	public static MemoService getInstance() {
		return instance;
	}

	private memoDAO dao = memoDAO.getInstance();
	public List<memoVO> selevMemos() throws Exception{
		return dao.selectMemos();
	}
	public memoVO selectMemo(int searchNo) throws Exception{
		return dao.selectMemo(searchNo);
	}
	public int insertMemo(memoVO vo)throws Exception {
		return dao.insertMemo(vo);
	}
	public int updateMemo(memoVO vo)throws Exception{
		return dao.updateMemo(vo);
	}
	public int deleteMemo(int deleteNo)throws Exception{
		return dao.deleteMemo(deleteNo);
	}
}

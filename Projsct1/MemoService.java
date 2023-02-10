package Projsct1;

import java.util.List;

public class MemoService {
	private MemoDAO dao = new MemoDAO();
	public List<MemoVO> selectMemos(String searchWord) throws Exception {
		return dao.selectMemos(searchWord);
	}
	public MemoVO selectMemo(int searchNo) {
		return dao.selectMemo(searchNo);
	}
	public int insertMemo(MemoVO vo) throws Exception {
		return dao.insertMemo(vo);
	}
	public int updateMemo(MemoVO vo) {
		return dao.updateMemo(vo);
	}
	public int deleteMemo(int deleteNo) {
		return dao.deleteMemo(deleteNo);
	}
}

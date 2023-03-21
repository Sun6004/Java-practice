package service;

import java.util.List;

import dao.BoardDao;
import dao.BoardDaoimpl;
import vo.BoardVO;

public class BoardServiceimpl implements BoardService{
	
	private BoardDao dao;
	
	private static BoardServiceimpl service;
	
	private BoardServiceimpl() {
		dao = BoardDaoimpl.getInstance();
	}
	public static BoardServiceimpl getInstance() {
		if(service==null) service = new BoardServiceimpl();
		return service;
	}
	
	public int insert(BoardVO boardVo) {
		return dao.insert(boardVo);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

	@Override
	public int update(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.update(boardVo);
	}
	public BoardVO getBoard(int boardNo) {
		int cnt = dao.serCountIncrement(boardNo);
		if(cnt == 0) { // 조회수 증가 실패
			return null;
		}
		return dao.getBoard(boardNo);
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		// TODO Auto-generated method stub
		return dao.getAllBoardList();
	}
	
	
	public int setCountIncrement(int boardNo) {
		return dao.serCountIncrement(boardNo);
	}
	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int serCountIncrement(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}

package service;

import java.util.List;

import dao.BoardDao;
import dao.BoardDaoimpl;
import vo.BoardVO;

public abstract class BoardServiceimpl implements BoardService{
	
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
		return 0;
	}

	@Override
	public int update(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}

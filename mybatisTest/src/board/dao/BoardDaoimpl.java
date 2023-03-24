package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import util.MybatisSqlsessionFactory;

public class BoardDaoimpl implements BoardDao{
	//1. 자신의 참조값이 저장될 변수
	private static BoardDaoimpl dao;
	
	//2. 기본생성자
	private BoardDaoimpl() {
		
	}
	//3. 
	public static BoardDaoimpl getInstance() {
		if(dao==null) dao = new BoardDaoimpl();
		return dao;
	}

	@Override
	public int insert (BoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			cnt = session.delete("board.insertBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int delete(int boardNo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			cnt = session.delete("board.deleteBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int update(BoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			cnt = session.delete("board.deleteBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		SqlSession session = null;
		BoardVO vo = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();		
			vo = session.selectOne("board.getBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return vo;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		SqlSession session = null;
		int cnt = 0;
		List<BoardVO> list = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("board.deleteBoard");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		return null;
		
		
	}

	@Override
	public int serCountIncrement(int boardNo) {
		
		
		return 0;
	}

	
}

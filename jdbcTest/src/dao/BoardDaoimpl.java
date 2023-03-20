package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import util.DBUtil3;
import vo.BoardVO;

public class BoardDaoimpl implements BoardDao{
	private static BoardDaoimpl dao;
	
	private BoardDaoimpl() {
		
	}
	
	public static BoardDaoimpl getInstance() {
		if(dao==null) dao = new BoardDaoimpl();
		return dao;
	}

	@Override
	public int insert(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into JDBC_BOARD(BOARD_NO, BOARD_TITLE,BOARD_WRITER,BOARD_DATE, BOARD_CNT, BOARD_CONTENT)"
					+ "values(BOARD_SEQ.nextval,?,?,sysdate,0,? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardVo.getBoard_title());
			ps.setString(2, boardVo.getBoard_writer());
			ps.setString(3, boardVo.getBoard_content());
			
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
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

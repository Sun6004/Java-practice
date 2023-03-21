package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil3;
import vo.BoardVO;

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
	public int insert(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement ps = null;
				int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board(board_no, board_title, board_writer, board_date, board_cnt, board_content)"
					+ "values(board_seq.nextval, ?, ?, sysdate,0, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardVo.getBoard_title());
			ps.setString(2, boardVo.getBoard_writer());
			ps.setString(3, boardVo.getBoard_content());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public int delete(int boardNo) {
		Connection conn = null;
		PreparedStatement ps = null;
				int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public int update(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement ps = null;
				int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title = ?, board_content = ?, board_date = sysdate"
					+ " where board_no = ? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardVo.getBoard_title());
			ps.setString(2, boardVo.getBoard_content());
			ps.setInt(3, boardVo.getBoard_no());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO boardVo = null; //반환값 변수
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board where board_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				boardVo = new BoardVO(); // 데이터를 저장할 VO객체 생성
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rs!=null)try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardVo;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> boardList= null; //반환값 변수
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board order by board_no desc";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			boardList = new ArrayList<>();
			while(rs.next()) {
				BoardVO boardVo = new BoardVO(); // 데이터를 저장할 VO객체 생성
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rs!=null)try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> boardList= null; //반환값 변수
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board where board_title like '%' || ? || '%' order by board_no desc";	
			ps = conn.prepareStatement(sql);
			ps.setString(1, "title");
			
			
			rs = ps.executeQuery();
			boardList = new ArrayList<>();
			while(rs.next()) {
				BoardVO boardVo = new BoardVO(); // 데이터를 저장할 VO객체 생성
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rs!=null)try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public int serCountIncrement(int boardNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update jdbc_board set board_cnt = board_cnt + 1 where board_no = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	
}

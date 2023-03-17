package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mvc.vo.MemberVO;
import util.DBUtil3;

public class MemberDaoimpl implements IMemberDao {

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0; //반환값
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) " + "values (?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, memVo.getMem_id());
			ps.setString(2, memVo.getMem_pass());
			ps.setString(3, memVo.getMem_name());
			ps.setString(4, memVo.getMem_tel());
			ps.setString(5, memVo.getMem_addr());
			
			cnt = ps.executeUpdate();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn!=null)try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
		
		
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int count = 0; //반환값
		try {
			con = DBUtil3.getConnection();
			 String sql = "select * from MYMEMBER where mem_id = ?";
			 ps.getConnection().prepareStatement(sql);
			 ps.setString(1, memId);
			 
			 rs = ps.executeQuery();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return count;
	}

}

package jdbc;
/*
 * LPROD 테이블에 새로운 데이터 추가하기
 * lprod_gu, lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1 크게 한다.
 * 
 * 입력받은 lprod_qu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

public class JdbcTest05 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
			
			con = DBUtil.getConnection();
			
			
			System.out.print("상품코드 입력>>");
			String gu = sc.next();
			System.out.print("상품명 입력>>");
			String nm = sc.next();
		
			int id = 0;
			int count = 0;
			
			//lprod_id 최대값에서 1씩 자동증가하는 id값 생성
			String sql = "select max(lprod_id)+1 from lprod";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				 id = rs.getInt(1);
				//System.out.println(id);
			}
			
			//gu값 중복검사
			String sql2 = "select count(*) from lprod where lprod_gu='" + gu + "'";
			rs = st.executeQuery(sql2);
			
			if(rs.next()) {
			count = rs.getInt(1);
			//System.out.println(count);
			}
			
			//gu값이 중복되지 않았을때 insert문 실행
			if(count == 0) {
			String sql3 = "insert into LPROD (LPROD_ID, LPROD_GU, LPROD_NM)"+
					"values('" + id + "','" + gu + "','" + nm + "')";
			st = con.createStatement();
			int cnt = st.executeUpdate(sql3);
			if(cnt > 0) {
			System.out.println("상품 등록 성공!");
			}
		
			}else {
				System.out.println("상품 등록 실패!");
				System.out.println("중복된상품코드 번호입니다.");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {
				rs.close();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			if(ps!=null)try {
				ps.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			if(st!=null)try {
				st.close(); 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(con!=null)try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제) lprod_id값을 2개를 입력받아서 두 값중 작은값부터 큰 사이의 자료들을 출력하시오.
public class JdbcTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("lprod_id값을 2개를 입력받아서 두 값중 작은값부터 큰 사이의 자료들을 출력하시오.");
		System.out.print("작은 값 입력: ");
		int minNum = sc.nextInt();
		System.out.print("큰 값 입력: ");
		int maxNum = sc.nextInt();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
			
			String sql = "SELECT * FROM lprod WHERE lprod_id BETWEEN'" + minNum + "'AND'" +maxNum +"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.println("처리결과");
			while(rs.next()) {
				System.out.println("id: " + rs.getInt("lprod_id"));
				System.out.println("상품코드: " + rs.getString("lprod_gu"));
				System.out.println("상품분류: " + rs.getString("lprod_nm"));
				System.out.println("----------------------------------------------");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(st != null)try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(con != null)try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

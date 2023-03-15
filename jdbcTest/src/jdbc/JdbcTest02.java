package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id 값을 입력받아
// 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.
public class JdbcTest02 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
			System.out.print("id값을 입력하세요");
			int id = sc.nextInt();
			
			String sql = "SELECT * FROM lprod WHERE lprod_id > "+id;
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("lprod_id"));
				System.out.println("상품코드: "+rs.getString("lprod_gu"));
				System.out.println("상품분류: "+rs.getString("lprod_nm"));
				System.out.println("-------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(st!=null)try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(con!=null)try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

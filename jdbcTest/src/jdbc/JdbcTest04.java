package jdbc;
//bankinfo 테이블에 계좌번호 정보를 추가하는 예제

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {
	private static Scanner sc;

	public static void main(String[] args) {
		
	
	sc = new Scanner(System.in);

	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
		
		System.out.println("계좌번호 정보 추가하기");
		System.out.print("계좌번호 입력>> ");
		String bankNo = sc.next();
		
		System.out.print("은행명 입력>> ");
		String bankName = sc.next();
		
		System.out.print("예급주명 입력>> ");
		String userName = sc.next();
		
//		//Statement 객체를 이용하여 데이터 추가하기
//		String sql ="insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)" +
//		"values ('" + bankNo + "','" + bankName + "','" + userName + "', sysdate)";
//		
//		System.out.println("SQL문 ==> " +sql);
//		
//		st = con.createStatement();
//		
//		//select문을 실행할 때는 executeQuery()메서드를 사용하고
//		//select문이 아닌 문장(insert, update, delete등)을 실행할 때는 executeUpdate()메서드 사용
//		int cnt = st.executeUpdate(sql);
//		System.out.println("반환값: " + cnt);
		
	
		
		//PreparedStatement 객체를 이용하여 처리하기
		
		//SQL문을 작성할 때 SQL문에서 데이터가 들어갈 자리를 ?로 표시하여 작성한다.
		String sql = "insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)" +
	            "values (?, ?, ?, sysdate)";
		
		//prepareStatement객체생성 => 사용할sql문을 인수값으로 넘김
		ps = con.prepareStatement(sql);
		
		//sql문의 ?자리에 들어갈 데이터를 세팅한다
		//형식) ps.set 자료형이름(?순번, 세팅할 데이터)
		ps.setString(1, bankNo);
		ps.setString(2, bankName);
		ps.setString(3, userName);
		
		
		//데이터의 세팅이 완료되면 실행
		//select문일 경우 => executeQuery()메서드 이용
		//select문이 아닐 경우 => excuteUpdate()메서드 이용
		
		int cnt = ps.executeUpdate();
		System.out.println("반환값: " + cnt);
		
		

		
	} catch (Exception e) {
		 e.printStackTrace();
	}finally {
		if(ps!=null)try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(st!=null)try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null)try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}
}

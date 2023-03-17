package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

// JDBC 드라이버를 로딩하고 Connection객체를 생성해서 반환하는 메서드로 구성된 class
// (dbinfo.properties파일을 이용해 설정하는 방법)
// ResourceBundle객체 이용하기
public class DBUtil3 {
	private static ResourceBundle bundle; //ResourceBundle객체 변수 선언
	static {
		bundle = ResourceBundle.getBundle("config.dbinfo");
	
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//Connection객체를 반환하는 메서드
	
	public static Connection getConnection() {
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
			return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (Exception e) {
			System.out.println("DB연결 실패!");
			e.printStackTrace();
			return null;
		}
	}
}

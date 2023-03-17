package util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// JDBC 드라이버를 로딩하고 Connection객체를 생성해서 반환하는 메서드로 구성된 class
// (dbinfo.properties파일을 이용해 설정하는 방법)

//propreties를 이용
public class DBUtil2 {
	private static Properties prop; //properties객체 변수 선언
	
	static {
		prop = new Properties(); //properties객체 생성
		File f = new File("res/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(f);
			prop.load(fin);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
			
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//Connection객체를 반환하는 메서드
	
	public static Connection getConnection() {
		try {
			//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java");
			return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
		} catch (Exception e) {
			System.out.println("DB연결 실패!");
			e.printStackTrace();
			return null;
		}
	}
}
